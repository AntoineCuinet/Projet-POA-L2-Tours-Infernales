/**
 * Represents a border object in a grid.
 */
public class Border extends Occupant {
    private boolean horizontal; // Indicates if the border is horizontal
    private boolean vertical;   // Indicates if the border is vertical

    // ASCII art representation of different types of borders
    private static final String mur = Color.red() + "\u2588" + Color.reset();
    private static final String murBas = Color.red() + "\u2584" + Color.reset();
    private static final String murHaut = Color.red() + "\u2580" + Color.reset();

    /**
     * Constructs a new Border object with the specified parameters.
     *
     * @param grid       The grid in which the border will be placed.
     * @param pos        The position of the border in the grid.
     * @param horizontal Indicates whether the border is horizontal.
     * @param vertical   Indicates whether the border is vertical.
     */
    public Border(Grid grid, Position pos, boolean horizontal, boolean vertical) {
        super(grid, pos);
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    /**
     * Redirects the movement of an object when it encounters the border.
     *
     * @param m The object whose movement needs to be redirected.
     */
    @Override
    public void redirect(Moving m) {
        m.getVelocity().rebond(horizontal, vertical);
    }

    /**
     * Returns a string representation of the border function of its orientation.
     *
     * @return The string representation of the border.
     */
    @Override
    public String toString() {
        if (vertical && !horizontal) {
            return mur;
        } else if (horizontal && getPosition().y() == 0) {
            return murHaut + murHaut + murHaut + murHaut;
        } else {
            return murBas + murBas + murBas + murBas;
        }
    }
}
