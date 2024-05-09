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
        // TODO: check and return move's validity
        this.setPosition(pos);
        return true;
    }
}
