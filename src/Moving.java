/**
 * Represents an abstract class for moving occupants within a grid.
 * Extends the Occupant class and implements the Moveable interface.
 */
public abstract class Moving extends Occupant implements Moveable {
    private Direction direction;

    /**
     * Constructs a new Moving object with the specified parameters.
     *
     * @param grid      The grid in which the object will be placed.
     * @param position  The position of the occupant in the grid.
     * @param direction The initial direction of movement.
     */
    public Moving(Grid grid, Position position, Direction direction) {
        super(grid, position);
        this.direction = direction;
    }

    /**
     * Gets the velocity (direction) of the moving object.
     *
     * @return The velocity (direction) of the moving object.
     */
    public Direction getVelocity() {
        return this.direction;
    }

    /**
     * Gets the present position of the moving object.
     *
     * @return The present position of the moving object.
     */
    @Override
    public Position getPresentPosition() {
        return this.getPosition();
    }

    /**
     * Gets the target position of the moving object based on its current direction.
     *
     * @return The target position of the moving object.
     */
    @Override
    public Position getTargetPosition() {
        return this.getPosition().move(this.direction);
    }

    /**
     * Moves the object to the specified position.
     *
     * @param pos The position to move the object to.
     * @return True if the object successfully moves to the position, otherwise false.
     */
    @Override
    public boolean moveTo(Position pos) {
        Occupant occ = getGrid().getAtPosition(pos);
        // position already fill case
        if (occ != null) {
            occ.redirect(this);
            return false;
        }
        // move
        this.setPosition(pos);
        return true;
    }
}
