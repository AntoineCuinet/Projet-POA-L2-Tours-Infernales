import java.util.PriorityQueue;
import java.util.Queue;

public class Supervisor {
    private Grid grid;
    private Perso[] players;
    private Tower[] towers;
    private int refreshRate;

    private static final int TOWER_MAX_HEIGHT = 5;

    public Supervisor(int gridWidth, int gridHeight, int nbrPlayer, int nbrTower, int refreshRate) throws InvalidVelocityException {
        this.grid = new Grid(gridWidth, gridHeight);
        this.players = new Perso[nbrPlayer];
        this.towers = new Tower[nbrTower];
        for (int i=0 ; i < nbrPlayer ; i++) {
            this.players[i] = new Perso(grid, grid.randomFreePosition());
        }
        for (int i=0 ; i < nbrTower ; i++) {
            this.towers[i] = new Tower(grid, TOWER_MAX_HEIGHT);
        }
        this.refreshRate = refreshRate;
    }

    public Perso[] play(int maxRound) throws InterruptedException {
        // first clear
        clearScreen();
        // display initial state
        System.out.println(this.grid);
        Thread.sleep(this.refreshRate);
        // start game loop
        int round = 1;
        while (!gameFinished() && (round <= maxRound || maxRound <= 0)) {
            // play round for each players
            for (Perso player : this.players) {
                player.update();
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

    public boolean gameFinished() {
        for (Tower tower : this.towers) {
            if (!tower.isOwned()) {
                return false;
            }
        }
        return true;
    }

    public static void clearScreen() {
        for (int i=0 ; i < 10 ; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static int randInt(int max) {
        return (int)(Math.random() * max);
    }

    public static int randInt(int min, int max) {
        return (int)(Math.random() * (max-min+1)) + min;
    }
}
