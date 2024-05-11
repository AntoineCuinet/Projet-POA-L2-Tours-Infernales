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

    public Direction() {
        this.vx = 0;
        this.vy = 0;
        this.vz = 0;
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

    public void setRandom() {
        this.vz = 0;
        do {
            this.vx = (int)(Math.random() * 3) - 1;
            this.vy = (int)(Math.random() * 3) - 1;
        } while (this.vx == 0 && this.vy == 0);
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

    public void lift() {
        this.vx = 0;
        this.vy = 0;
        this.vz = 1;
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
        Direction dir = new Direction();
        dir.setRandom();
        return dir;
    }
}
