/**
 * The Explosion class represents an explosion occurring at a specific position on the grid.
 */
public class Explosion extends Occupant{
    private static final String EXPLOSION = "\u2739";

    private boolean alreadyShowed;

    /**
     * Constructs an Explosion at the given position on the specified grid.
     *
     * @param grid      The grid on which the explosion occurs.
     * @param position  The position of the explosion on the grid.
     */
    public Explosion(Grid grid, Position position) {
        super(grid, position);
        this.alreadyShowed = false;
    }

    /**
     * Destroys the explosion by removing it from the grid.
     */
    public void destroy() {
        getGrid().removeAtPosition(getPosition());
    }

    /**
     * Redirects a moving object by reversing its direction.
     *
     * @param m The moving object to redirect.
     */
    @Override
    public void redirect(Moving m) {
        m.getVelocity().reverse();
    }

    /**
     * Returns a string representation of the explosion.
     * If the explosion has already been shown, it destroys itself.
     *
     * @return A string representing the explosion.
     */
    @Override
    public String toString() {
        if (alreadyShowed) {
            destroy();
        }
        this.alreadyShowed = true;
        return ' ' + EXPLOSION + ' ';
    }
}
