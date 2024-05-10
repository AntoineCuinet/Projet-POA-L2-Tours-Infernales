public class Perso extends Moving {
    private static final String perso = "\u263A";

    public Perso(Grid grid, Position position, Direction direction) {
        super(grid, position, direction);
    }

    public Perso(Grid grid, Position position) {
        this(grid, position, Direction.randomDirection());
    }

    public void update() {
        moveTo(getTargetPosition());
    }

    @Override
    public void redirect(Moving m) {
        m.getVelocity().reverse();
    }

    @Override
    public String toString() {
        return perso;
    }
}