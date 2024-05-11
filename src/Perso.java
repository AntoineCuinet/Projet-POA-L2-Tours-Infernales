public class Perso extends Moving {
    private static final String PERSO = "\u263A";

    private static int nbrPlayer = 0;

    private String color;

    public Perso(Grid grid, Position position, Direction direction) {
        super(grid, position, direction);
        this.color = Color.array()[nbrPlayer % Color.array().length];
        nbrPlayer++;
    }

    public Perso(Grid grid, Position position) {
        this(grid, position, Direction.randomDirection());
    }

    public String getColor() {
        return this.color;
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
        return ' ' + this.color + PERSO + Color.reset() + ' ';
    }
}