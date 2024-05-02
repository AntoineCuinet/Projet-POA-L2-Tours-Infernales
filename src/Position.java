public class Position {
    private int x;
    private int y;
    private int z;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void x (int x) {
        this.x = x;
    }

    public void y (int y) {
        this.y = y;
    }

    public void z (int z) {
        this.z = z;
    }

    public int x () {
        return this.x;
    }

    public int y () {
        return this.y;
    }

    public int z () {
        return this.z;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}
