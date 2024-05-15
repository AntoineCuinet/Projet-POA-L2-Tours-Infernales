public class MeteorRain implements Active {
    private Grid grid;
    private double probability;

    public MeteorRain(Grid grid, double probability) throws IllegalArgumentException {
        // check args
        if (probability < 0f || probability > 1f) {
            throw new IllegalArgumentException("Meteor probability must be in the [0,1] interval");
        }
        // init meteor rain
        this.grid = grid;
        this.probability = probability;
    }

    public MeteorRain(Grid grid) {
        this.grid = grid;
        this.probability = 0.5f;
    }

    @Override
    public void update() {
        // launch a meteor or not
        if (Math.random() <= this.probability) {
            // choose a random cell and get it
            Position pos = this.grid.randomIndoorPosition();
            Occupant target = this.grid.getAtPosition(pos);
            // explode the player if it exists
            if (target instanceof Perso) {
                Perso player = (Perso)target;
                if (player.isAlive()) {
                    player.explode();
                }
            }
            else if (target == null) {
                new Explosion(this.grid, pos);
            }
        }
    }
}
