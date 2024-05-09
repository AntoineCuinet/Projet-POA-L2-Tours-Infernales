import java.util.Objects;

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

    public Position move(Direction dir) {
        return new Position(x+dir.getVx(), y+dir.getVy(), z+dir.getVz());
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Position other = (Position)obj;
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
