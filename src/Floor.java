/**
 * Represents a floor object of a tower in a grid.
 */
public class Floor extends Occupant {
    private static final String OWNED_TOWER = "\u25A3"; // Unicode symbol for a tower owned by a player
    private static final String TOWER = "\u25A1"; // Unicode symbol for an unowned tower

    private Tower tower;

    /**
     * Constructs a new Floor object with the specified parameters.
     *
     * @param grid     The grid in which the floor will be placed.
     * @param position The position of the floor in the grid.
     * @param tower    The tower who own the floor.
     */
    public Floor(Grid grid, Position position, Tower tower) {
        super(grid, position);
        this.tower = tower;
    }

    /**
     * Redirects the movement of an object when it encounters the floor with reverse its direction.
     *
     * @param m The object whose movement needs to be redirected.
     */
    @Override
    public void redirect(Moving m) {
        Position mPos = m.getPosition();
        Direction mDir = m.getVelocity();
        // case in
        if (mPos.z() == 0) {
            // get if the first floor is free
            Position firstFloor = new Position(getPosition().x(), getPosition().y(), 1);
            if (getGrid().getAtPosition(firstFloor) == null) {
                // go to first floor and start ascension
                m.setPosition(firstFloor);
                mDir.lift();
                this.tower.occupantIn(m);
            }
            else {
                // first floor already used
                mDir.reverse();
            }
        }
        // case out
        else {
            Position dstPos = getGrid().randomNextToPosition(getPosition());
            if (dstPos != null) {
                m.setPosition(dstPos);
                mDir.setRandom();
                this.tower.occupantOut(m);
            }
        }
    }

    /**
     * Returns a string representation of the floor.
     *
     * @return The string representation of the floor.
     */
    @Override
    public String toString() {
        if (this.tower.isOwned()) {
            return ' ' + this.tower.getOwner().getColor() + OWNED_TOWER + Color.reset() + ' ';
        }
        return ' ' + TOWER + ' ';
    }
}
