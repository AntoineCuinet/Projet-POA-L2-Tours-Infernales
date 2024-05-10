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

    public void rebond(boolean wallH, boolean wallV) {
        if (wallH) {
            this.vy = -this.vy;
        }
        if (wallV) {
            this.vx = -this.vx;
        }
    }

    public void reverse() {
        this.vx = -this.vx;
        this.vy = -this.vy;
        this.vz = -this.vz;
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

    public static Direction randomDirection() {
        Direction dir;
        int vx;
        int vy;
        do {
            vx = (int)(Math.random() * 3) - 1;
            vy = (int)(Math.random() * 3) - 1;
        } while (vx == 0 && vy == 0);
        try {
            dir = new Direction(vx, vy, 0);
        } catch (InvalidVelocityException e) {
            dir = null;
        }
        return dir;
    }
}
