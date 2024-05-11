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

    public void play(int nbrRound) throws InterruptedException {
        // first clear
        clearScreen();
        // display initial state
        System.out.println(this.grid);
        Thread.sleep(this.refreshRate);
        // start game loop
        for (int i=0 ; i < nbrRound ; i++) {
            for (Perso player : this.players) {
                player.update();
            }
            clearScreen();
            System.out.println(this.grid);
            for (Tower tower : this.towers) {
                if (!tower.isEmpty()) {
                    System.out.println(tower);
                }
            }
            Thread.sleep(this.refreshRate);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

    public static int randInt(int max) {
        return (int)(Math.random() * max);
    }

    public static int randInt(int min, int max) {
        return (int)(Math.random() * (max-min+1)) + min;
    }
}
