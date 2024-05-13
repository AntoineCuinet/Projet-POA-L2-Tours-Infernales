/**
 * Represents a direction in 3D space with the game specified rules.
 */
public class Direction {
    private int vx; // Velocity along the x-axis
    private int vy; // Velocity along the y-axis
    private int vz; // Velocity along the z-axis

    /**
     * Constructs a new Direction object with the specified velocities.
     *
     * @param vx The velocity along the x-axis.
     * @param vy The velocity along the y-axis.
     * @param vz The velocity along the z-axis.
     * @throws InvalidVelocityException If the given velocities are invalid.
     */
    public Direction(int vx, int vy, int vz) throws InvalidVelocityException {
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;

        if (!checkValidity(vx, vy, vz)) {
            throw new InvalidVelocityException("Invalid velocity");
        }
    }

    /**
     * Constructs a new Direction object with default velocities (0, 0, 0).
     * Not throws any exceptions.
     */
    public Direction() {
        this.vx = 0;
        this.vy = 0;
        this.vz = 0;
    }

    /**
     * Gets the velocity along the x-axis.
     *
     * @return The velocity along the x-axis.
     */
    public int getVx() {
        return vx;
    }

    /**
     * Gets the velocity along the y-axis.
     *
     * @return The velocity along the y-axis.
     */
    public int getVy() {
        return vy;
    }

    /**
     * Gets the velocity along the z-axis.
     *
     * @return The velocity along the z-axis.
     */
    public int getVz() {
        return vz;
    }

    /**
     * Sets random non-zero velocities for x and y axes, and zero for z-axis.
     */
    public void setRandom() {
        this.vz = 0;
        do {
            this.vx = (int)(Math.random() * 3) - 1;
            this.vy = (int)(Math.random() * 3) - 1;
        } while (this.vx == 0 && this.vy == 0);
    }

    /**
     * Adjusts the direction of movement based on horizontal and vertical walls.
     *
     * @param wallH Indicates if there's a horizontal wall.
     * @param wallV Indicates if there's a vertical wall.
     */
    public void rebond(boolean wallH, boolean wallV) {
        if (wallH) {
            this.vy = -this.vy;
        }
        if (wallV) {
            this.vx = -this.vx;
        }
    }

    /**
     * Reverses the direction of movement.
     */
    public void reverse() {
        this.vx = -this.vx;
        this.vy = -this.vy;
        this.vz = -this.vz;
    }

    /**
     * Sets the direction to move vertically upwards.
     */
    public void lift() {
        this.vx = 0;
        this.vy = 0;
        this.vz = 1;
    }

    /**
     * Checks if the given velocities are valid.
     *
     * @param vx The velocity along the x-axis.
     * @param vy The velocity along the y-axis.
     * @param vz The velocity along the z-axis.
     * @return True if the velocities are valid, otherwise false.
     */
    public static boolean checkValidity(int vx, int vy, int vz) {
        if (vx < -1 || vx > 1 || vy < -1 || vy > 1 || vz < -1 || vz > 1) {
            return false;
        }

        if (vz != 0 && (vx != 0 && vy != 0)) {
            return false;
        }

        return true;
    }

    /**
     * Generates a random direction object.
     *
     * @return A randomly generated Direction object.
     */
    public static Direction randomDirection() {
        Direction dir = new Direction();
        dir.setRandom();
        return dir;
    }
}
