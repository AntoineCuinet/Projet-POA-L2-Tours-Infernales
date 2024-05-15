/**
 * The Snowman class represents an occupant on the grid that can freeze players.
 */
public class Snowman extends Occupant {
    private static final String SNOWMAN = "\u26C7";

    private int freezeCapacity;

    /**
     * Constructs a Snowman with a specified grid, position, and freeze capacity.
     *
     * @param grid              The grid the snowman is placed on
     * @param position          The position of the snowman on the grid
     * @param freezeCapacity    The freeze capacity of the snowman
     */
    public Snowman(Grid grid, Position position, int freezeCapacity) {
        super(grid, position);
        this.freezeCapacity = freezeCapacity;
    }

    /**
     * Constructs a Snowman with a specified grid and position.
     * The freeze capacity defaults to 6.
     *
     * @param grid      The grid the snowman is placed on.
     * @param position  The position of the snowman on the grid.
     */
    public Snowman(Grid grid, Position position) {
        this(grid, position, 6);
    }

    /**
     * Redirects a moving object. If the object is a player (Perso), it freezes the player.
     * Then, the snowman removes itself from the grid.
     *
     * @param m The moving object to be redirected.
     */
    @Override
    public void redirect(Moving m) {
        // freeze player
        if (m instanceof Perso) {
            Perso player = (Perso)m;
            player.freeze(this.freezeCapacity);
        }
        // kill itself
        getGrid().removeAtPosition(getPosition());
    }

    /**
     * Returns a string representation of the Snowman.
     *
     * @return A string representing the snowman.
     */
    @Override
    public String toString() {
        return ' ' + SNOWMAN + ' ';
    }
}
