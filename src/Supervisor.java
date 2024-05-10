public class Supervisor {
    private Grid grid;
    private Perso[] players;
    private int refreshRate;

    public Supervisor(int gridWidth, int gridHeight, int nbrPlayer, int refreshRate) throws InvalidVelocityException {
        this.grid = new Grid(gridWidth, gridHeight);
        this.players = new Perso[nbrPlayer];
        for (int i=0 ; i < nbrPlayer ; i++) {
            Position pos = grid.randomFreePosition();
            Direction dir = new Direction(randInt(-1, 1), randInt(-1, 1), 0);
            this.players[i] = new Perso(grid, pos, dir);
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
            for (Perso player : players) {
                player.update();
            }
            clearScreen();
            System.out.println(this.grid);
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
