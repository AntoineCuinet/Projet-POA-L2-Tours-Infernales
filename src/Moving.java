public abstract class Moving extends Occupant implements Moveable {

    public Moving(Grid grid, Position position) {
        super(grid, position);
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
