import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents a grid containing occupants in a 3D space.
 */
public class Grid {
    private static final String WALL = Color.red() + "\u2588" + Color.reset(); // Unicode symbol for a wall

    private int width;
    private int height;
    private Map<Position, Occupant> occupants;

    /**
     * Constructs a new Grid object with the specified width and height.
     *
     * @param width  The width of the grid.
     * @param height The height of the grid.
     */
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

    /**
     * Constructs a new Grid object with default width and height.
     * Default width is 20 and default height is 10.
     */
    public Grid() {
        this(20, 10);
    }

    /**
     * Adds an occupant to the grid.
     *
     * @param occupant The occupant to add.
     */
    public void addOccupant(Occupant occupant) {
        this.occupants.put(occupant.getPosition(), occupant);
    }

    /**
     * Take in account the movement of an occupant
     *
     * @param occupant The occupant to move.
     * @param position The new position of the occupant.
     */
    public void moveOccupant(Occupant occupant, Position position) {
        this.occupants.remove(occupant.getPosition());
        this.occupants.put(position, occupant);
    }

    /**
     * Gets the occupant at the specified position in the grid.
     *
     * @param pos The position to check.
     * @return The occupant at the specified position, or null if no occupant is present.
     */
    public Occupant getAtPosition(Position pos) {
        return this.occupants.get(pos);
    }

    public void removeAtPosition(Position pos) {
        this.occupants.remove(pos);
    }

    /**
     * Returns a set of all empty positions within the grid.
     *
     * @return A set of positions that are currently empty.
     */
    public Set<Position> getEmptyPositions() {
        Set<Position> freePos = new HashSet<Position>();
        for (int x=1 ; x < this.width-1 ; x++) {
            for (int y=1 ; y < this.height-1 ; y++) {
                Position pos = new Position(x, y, 0);
                if (getAtPosition(pos) == null) {
                    freePos.add(pos);
                }
            }
        }
        return freePos;
    }

    /**
     * Generates a random indoor position within the grid.
     *
     * @return A random indoor position within the grid.
     */
    public Position randomIndoorPosition() {
        int x = (int)(Math.random() * (width-2)) + 1;
        int y = (int)(Math.random() * (height-2)) + 1;
        return new Position(x, y, 0);
    }

    /**
     * Generates a random empty position within the grid.
     *
     * @return A random empty position within the grid.
     *
     * @throws NotEnoughPlaceException If not enough place is available.
     */
    public Position randomEmptyPosition() throws NotEnoughPlaceException {
        Position[] freePos = getEmptyPositions().toArray(new Position[0]);
        // check if enough place is available
        if(freePos.length == 0) {
            throw new NotEnoughPlaceException();
        }
        // choose a random empty position
        int index = (int)(Math.random() * freePos.length);
        return freePos[index];
    }

    /**
     * Generates a random free position adjacent to the specified position.
     *
     * @param pos The position to find adjacent positions.
     * @return A random free position adjacent to the specified position, or null if no adjacent position is free.
     */
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

    /**
     * Returns a string representation of the grid.
     *
     * @return The string representation of the grid.
     */
    @Override
    public String toString() {
        String dst = "";
        for (int i = 0; i < this.height; i++) {
            if (i > 0 && i < this.height - 1) {
                dst += WALL + " ";
            } else {
                dst += WALL;
            }
            for (int j = 1; j < this.width + 1; j++) {
                Position curPos = new Position(j, i, 0);
                if (this.occupants.containsKey(curPos)) {
                    if (this.occupants.get(curPos) instanceof Border) {
                        dst += this.occupants.get(curPos);
                    } else {
                        dst += this.occupants.get(curPos) + "|";
                    }
                } else {
                    dst += "   |";
                }
                if (j > this.width - 3) {
                    dst = dst.substring(0, dst.length() - 1);
                    dst += ' ';
                }
            }
            dst = dst.substring(0, dst.length() - 1);
            if(i == 0) {
                dst = dst.substring(0, dst.length() - 10);
                dst += "\n";
            } else {
                dst += " " +  "\n" + WALL;
            }

            if (i < this.height - 2) {
                for (int j = 0; j < this.width - 2; j++) {
                    if (i != 0) {
                        dst += " ---";
                    }
                    else {
                        dst = dst.substring(0, dst.length() - 2);
                    }
                }
            } else {
                dst = dst.substring(0, dst.length() - 23);
            }
            dst += " " + WALL + "\n";
        }
        dst = dst.substring(0, dst.length() - 29);
        dst += WALL + "\n\n";
        return dst;
    }
}