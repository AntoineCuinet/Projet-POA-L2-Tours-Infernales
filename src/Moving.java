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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPresentPosition'");
    }

    @Override
    public Position getTargetPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTargetPosition'");
    }

    @Override
    public boolean moveTo(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveTo'");
    }
    
}
