import java.util.HashMap;
import java.util.Map;

public class Grid {
    private int width;
    private int height;
    private Map<Position, Occupant> occupants;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.occupants = new HashMap<Position, Occupant>();
    }

    public Grid() {
        this(20, 10);
    }

    public void addOccupant(Occupant occupant) {
        this.occupants.put(occupant.getPosition(), occupant);
    }

    public void moveOccupant(Occupant occupant, Position position) {
        this.occupants.remove(occupant.getPosition());
        this.occupants.put(position, occupant);
    }

    @Override
    public String toString() {
        String dst = "";
        for (int i=0 ; i < this.height ; i++) {
            for (int j=0 ; j < this.width ; j++) {
                if (this.occupants.containsKey(new Position(j, i, 0))) {
                    dst += '@';
                }
                else {
                    dst += '#';
                }
            }
            dst += '\n';
        }
        return dst;
    }
}
