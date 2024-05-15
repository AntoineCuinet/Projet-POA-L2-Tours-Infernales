import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Represents a supervisor managing the game environment and player interactions.
 */
public class Supervisor {
    private Grid grid;
    private Set<Active> actives;
    private Perso[] players;
    private Tower[] towers;
    private int refreshRate;

    private static final int TOWER_MAX_HEIGHT = 5;

    /**
     * Constructs a new Supervisor object with the specified parameters.
     *
     * @param gridWidth     The width of the grid.
     * @param gridHeight    The height of the grid.
     * @param nbrPlayer     The number of player characters.
     * @param nbrTower      The number of towers.
     * @param refreshRate   The refresh rate for updating the game state.
     */
    public Supervisor(int gridWidth, int gridHeight, int nbrPlayer, int nbrTower, int refreshRate) throws IllegalArgumentException, NotEnoughPlaceException {
        // args check
        int maxPlayer = Color.array().length;
        if (nbrPlayer < 1 || nbrPlayer > maxPlayer) {
            throw new IllegalArgumentException("nrbPlayer must be between 1 and " + maxPlayer + " (inclusive)");
        }
        if (gridWidth < 1 || gridHeight < 1) {
            throw new IllegalArgumentException("Grid must have strictly positive dimentions");
        }
        if (nbrTower < 1) {
            throw new IllegalArgumentException("It must have 1 tower at least");
        }
        // init supervisor
        this.grid = new Grid(gridWidth, gridHeight);
        this.actives = new HashSet<Active>();
        this.players = new Perso[nbrPlayer];
        this.towers = new Tower[nbrTower];
        this.refreshRate = refreshRate;
        // create meteor rain
        this.actives.add(new MeteorRain(grid, 0.8));
        // create players
        for (int i=0 ; i < nbrPlayer ; i++) {
            this.players[i] = new Perso(grid, grid.randomEmptyPosition());
            this.actives.add(this.players[i]);
        }
        // create towers
        for (int i=0 ; i < nbrTower ; i++) {
            this.towers[i] = new Tower(grid, TOWER_MAX_HEIGHT);
        }
    }

    /**
     * Play the game for a max specified number of rounds.
     *
     * @param maxRound The maximum number of rounds to play. Use 0 or a negative number for unlimited rounds.
     * @return An array containing the player characters sorted by the number of towers they own in descending order.
     * @throws InterruptedException If the thread is interrupted while sleeping.
     */
    public Perso[] play(int maxRound) throws InterruptedException {
        // first clear
        clearScreen();
        // display initial state
        System.out.println(this.grid);
        Thread.sleep(this.refreshRate);
        // start game loop
        int round = 1;
        while (!gameFinished() && (round <= maxRound || maxRound <= 0)) {
            // play round for each actives objects
            for (Active entity : this.actives) {
                entity.update();
            }
            clearScreen();
            // display grid
            System.out.println(this.grid);
            // display non empty towers
            for (Tower tower : this.towers) {
                if (!tower.isEmpty()) {
                    System.out.println(tower);
                }
            }
            // sleep
            Thread.sleep(this.refreshRate);
            round++;
        }
        // get and return players in order using heap sort
        Queue<Perso> heap = new PriorityQueue<Perso>();
        for (Perso player : this.players) {
            heap.add(player);
        }
        for (int i=this.players.length-1 ; i >= 0 ; i--) {
            this.players[i] = heap.poll();
        }
        return this.players;
    }

    /**
     * Checks if the game has finished. Get if all towers are occupied.
     *
     * @return True if all towers are owned, otherwise false.
     */
    public boolean gameFinished() {
        for (Tower tower : this.towers) {
            if (!tower.isOwned()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Clears the console screen.
     */
    public static void clearScreen() {
        for (int i=0 ; i < 10 ; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    /**
     * Generates a random integer between 0 (inclusive) and the specified maximum value (exclusive).
     *
     * @param max The maximum value (exclusive).
     * @return A random integer.
     */
    public static int randInt(int max) {
        return (int)(Math.random() * max);
    }

    /**
     * Generates a random integer between the specified minimum and maximum values (both inclusive).
     *
     * @param min The minimum value (inclusive).
     * @param max The maximum value (inclusive).
     * @return A random integer.
     */
    public static int randInt(int min, int max) {
        return (int)(Math.random() * (max-min+1)) + min;
    }
}
