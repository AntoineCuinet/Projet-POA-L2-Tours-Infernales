/**
 * Represents an interface for objects that can be moved to different positions in a grid.
 */
public interface Moveable {
    /**
     * Gets the present position of the moveable object.
     *
     * @return The present position of the moveable object.
     */
    Position getPresentPosition();

    /**
     * Gets the target position of the moveable object. Correspond to the next move of it.
     *
     * @return The target position of the moveable object.
     */
    Position getTargetPosition();

    /**
     * Moves the moveable object to the specified position.
     *
     * @param pos The position to move the object to.
     * @return True if the object successfully moves to the position, otherwise false.
     */
    boolean moveTo(Position pos);
}
