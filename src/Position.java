import java.util.Objects;

/**
 * Represents a position in a three-dimensional space.
 */
public class Position {
    private int x;
    private int y;
    private int z;

    /**
     * Constructs a new Position object with the specified coordinates.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param z The z-coordinate.
     */
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Sets the x-coordinate of the position.
     *
     * @param x The new x-coordinate.
     */
    public void x (int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the position.
     *
     * @param y The new y-coordinate.
     */
    public void y (int y) {
        this.y = y;
    }

    /**
     * Sets the z-coordinate of the position.
     *
     * @param z The new z-coordinate.
     */
    public void z (int z) {
        this.z = z;
    }

    /**
     * Gets the x-coordinate of the position.
     *
     * @return The x-coordinate.
     */
    public int x () {
        return this.x;
    }

    /**
     * Gets the y-coordinate of the position.
     *
     * @return The y-coordinate.
     */
    public int y () {
        return this.y;
    }

    /**
     * Gets the z-coordinate of the position.
     *
     * @return The z-coordinate.
     */
    public int z () {
        return this.z;
    }

    /**
     * Moves the position by the specified direction.
     *
     * @param dir The direction to move the position.
     * @return The new position after moving.
     */
    public Position move(Direction dir) {
        return new Position(x+dir.getVx(), y+dir.getVy(), z+dir.getVz());
    }

    /**
     * Returns a string representation of the position.
     *
     * @return The string representation of the position.
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    /**
     * Checks if this position is equal to another object.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal (have the same coordinates), otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        Position other = (Position)obj;
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    /**
     * Returns the hash code value for the position.
     * Used for HashMap do not use memory address of the object but its coordinates to found it.
     *
     * @return The hash code value for the position.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
