import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {
    private int width;
    private int height;
    private Map<Position, Occupant> occupants;

    public Grid(int width, int height) {
        this.width = width + 2;
        this.height = height + 2; // add two to take care about border
        this.occupants = new HashMap<Position, Occupant>();
        // create borders
        new Border(this, new Position(0, 0, 0), true, true);
        new Border(this, new Position(this.width-1, 0, 0), true, true);
        new Border(this, new Position(0, this.height-1, 0), true, true);
        new Border(this, new Position(this.width-1, this.height-1, 0), true, true);
        for (int i=1 ; i < this.width-1 ; i++) {
            new Border(this, new Position(i, 0, 0), true, false);
            new Border(this, new Position(i, this.height-1, 0), true, false);
        }
        for (int i=1 ; i < this.height-1 ; i++) {
            new Border(this, new Position(0, i, 0), false, true);
            new Border(this, new Position(this.width-1, i, 0), false, true);
        }
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

    public Occupant getAtPosition(Position pos) {
        return this.occupants.get(pos);
    }

    public Position randomIndoorPosition() {
        int x = (int)(Math.random() * (width-2)) + 1;
        int y = (int)(Math.random() * (height-2)) + 1;
        return new Position(x, y, 0);
    }

    public Position randomFreePosition() {
        Position pos;
        Occupant occ;
        do {
            pos = randomIndoorPosition();
            occ = getAtPosition(pos);
        } while (occ != null);
        return pos;
    }

    public Position randomNextToPosition(Position pos) {
        // get free positions across
        List<Position> freePos = new ArrayList<Position>();
        for (int i=-1 ; i <= 1 ; i++) {
            for (int j=-1 ; j <= 1 ; j++) {
                Position p = new Position(pos.x()+j, pos.y()+i, pos.z());
                if (getAtPosition(p) == null && !p.equals(pos)) {
                    freePos.add(p);
                }
            }
        }
        // choose random pos in the set
        if (freePos.isEmpty()) {
            return null;
        }
        int posIndex = (int)(Math.random() * freePos.size());
        return freePos.get(posIndex);
    }

    @Override
    public String toString() {
        String dst = "";
        for (int i=0 ; i < this.height ; i++) {
            for (int j=0 ; j < this.width ; j++) {
                Position curPos = new Position(j, i, 0);
                if (this.occupants.containsKey(curPos)) {
                    dst += this.occupants.get(curPos);
                }
                else {
                    dst += '.';
                }
            }
            dst += '\n';
        }
        return dst;
    }
}
