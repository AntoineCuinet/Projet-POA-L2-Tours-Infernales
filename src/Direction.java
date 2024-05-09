public class Direction {
    private int vx;
    private int vy;
    private int vz;

    public Direction(int vx, int vy, int vz) throws InvalidVelocityException {
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;

        if (!checkValidity(vx, vy, vz)) {
            throw new InvalidVelocityException("Invalid velocity");
        }
    }

    public Direction() throws InvalidVelocityException {
        this(0, 0, 0);
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public int getVz() {
        return vz;
    }

    public static boolean checkValidity(int vx, int vy, int vz) {
        if (vx < -1 || vx > 1 || vy < -1 || vy > 1 || vz < -1 || vz > 1) {
            return false;
        }

        if (vz != 0 && (vx != 0 && vy != 0)) {
            return false;
        }

        return true;
    }

    public void rebond() {
        this.vx = -this.vx;
        this.vy = -this.vy;
        this.vz = -this.vz;
    }

    public void reverse() {
        this.vx = -this.vx;
        this.vy = -this.vy;
        this.vz = -this.vz;
    }
}
