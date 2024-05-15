/**
 * The MeteorRain class represents an event where meteors randomly strike positions on the grid.
 * It implements the Active interface and periodically updates to potentially cause meteors to fall.
 */
public class MeteorRain implements Active {
    private Grid grid;
    private double probability;

    /**
     * Constructs a MeteorRain with a specified grid and probability of meteor strikes.
     *
     * @param grid          The grid on which meteors will strike.
     * @param probability   The probability of a meteor strike occurring during an update, between 0 and 1.
     * @throws IllegalArgumentException If the probability is not within the [0,1] interval.
     */
    public MeteorRain(Grid grid, double probability) throws IllegalArgumentException {
        // check args
        if (probability < 0f || probability > 1f) {
            throw new IllegalArgumentException("Meteor probability must be in the [0,1] interval");
        }
        // init meteor rain
        this.grid = grid;
        this.probability = probability;
    }

    /**
     * Constructs a MeteorRain with a specified grid and a default probability of 0.7 for meteor strikes.
     *
     * @param grid The grid on which meteors will strike.
     */
    public MeteorRain(Grid grid) {
        this.grid = grid;
        this.probability = 0.7f;
    }

    /**
     * Updates the state of the MeteorRain, potentially causing a meteor strike.
     * A random position on the grid is chosen, and if an occupant is present, it is affected by the meteor.
     */
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
