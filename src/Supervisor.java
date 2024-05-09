public class Supervisor {
    private Grid grid;
    private Perso[] players;

    public Supervisor(int gridWidth, int gridHeight, int nbrPlayer) throws InvalidVelocityException {
        this.grid = new Grid(gridWidth, gridHeight);
        this.players = new Perso[nbrPlayer];
        for (int i=0 ; i < nbrPlayer ; i++) {
            Position pos = new Position(randInt(gridWidth), randInt(gridHeight), 0);
            Direction dir = new Direction(randInt(-1, 1), randInt(-1, 1), 0);
            this.players[i] = new Perso(grid, pos, dir);
        }
    }

    public void play() {
        System.out.println(this.grid);
        for (int i=0 ; i < 5 ; i++) {
            for (Perso player : players) {
                player.moveTo(player.getTargetPosition());
            }
        }
        System.out.println(this.grid);
    }

    public static int randInt(int max) {
        return (int)(Math.random() * max);
    }

    public static int randInt(int min, int max) {
        return (int)(Math.random() * (max-min+1)) + min;
    }
}
