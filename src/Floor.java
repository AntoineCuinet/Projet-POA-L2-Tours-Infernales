public class Floor extends Occupant {
    private static final String OWNED_TOWER = "\u25A3";
    private static final String TOWER = "\u25A1";

    private Tower tower;

    public Floor(Grid grid, Position position, Tower tower) {
        super(grid, position);
        this.tower = tower;
    }

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

    @Override
    public String toString() {
        if (this.tower.isOwned()) {
            return ' ' + this.tower.getOwner().getColor() + OWNED_TOWER + Color.reset() + ' ';
        }
        return ' ' + TOWER + ' ';
    }
}
