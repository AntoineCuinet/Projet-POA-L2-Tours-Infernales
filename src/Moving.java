public abstract class Moving extends Occupant implements Moveable {
    private Direction direction;

    public Moving(Grid grid, Position position, Direction direction) {
        super(grid, position);
        this.direction = direction;
    }

    public Direction getVelocity() {
        return this.direction;
    }

    @Override
    public Position getPresentPosition() {
        return this.getPosition();
    }

    @Override
    public Position getTargetPosition() {
        return this.getPosition().move(this.direction);
    }

    @Override
    public boolean moveTo(Position pos) {
        Occupant occ = getGrid().getAtPosition(pos);
        // position already fill case
        if (occ != null) {
            occ.redirect(this);
            return false;
        }
        // move
        this.setPosition(pos);
        return true;
    }
}
