/**
 * Represents an abstract class for occupants within a grid.
 * Implements the Redirector interface.
 */
public abstract class Occupant implements Redirector {
    private Grid grid;
    private Position position;

    /**
     * Constructs a new Occupant object with the specified grid and position.
     *
     * @param grid     The grid in which the occupant will be placed.
     * @param position The position of the occupant in the grid.
     */
    public Occupant(Grid grid, Position position) {
        this.position = position;
        setGrid(grid);
    }

    /**
     * Constructs a new Occupant object with the specified grid and default position (0, 0, 0).
     *
     * @param grid The grid in which the occupant will be placed.
     */
    public Occupant(Grid grid) {
        this(grid, new Position(0, 0, 0));
    }

    /**
     * Gets the grid in which the occupant exists.
     *
     * @return The grid in which the occupant exists.
     */
    public Grid getGrid() {
        return this.grid;
    }

    /**
     * Gets the position of the occupant in the grid.
     *
     * @return The position of the occupant in the grid.
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Sets the position of the occupant in the grid.
     *
     * ## It's really incorrect that create this method for non-moving objects ! But we have to write a code without 'protected' visibility... ##
     *
     * @param position The new position of the occupant.
     */
    public void setPosition(Position position) {
        this.grid.moveOccupant(this, position);
        this.position = position;
    }

    /**
     * Sets the grid in which the occupant exists.
     *
     * @param grid The grid in which the occupant exists.
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
        grid.addOccupant(this);
    }
}
