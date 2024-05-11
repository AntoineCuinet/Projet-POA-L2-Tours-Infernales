public class Perso extends Moving {
    private static final String perso = "\u263A";
    private String color;

    public Perso(Grid grid, Position position, Direction direction) {
        super(grid, position, direction);
        this.color = randColor();
    }

    public Perso(Grid grid, Position position) {
        this(grid, position, Direction.randomDirection());
    }

    public void update() {
        moveTo(getTargetPosition());
    }

    public static String randColor() {
        int intRand = (int)(Math.random() * 3);

        switch (intRand) {
            case 0:
                return Main.ANSI_BLUE + perso + Main.ANSI_RESET;
            case 1:
                return Main.ANSI_GREEN + perso + Main.ANSI_RESET;
            case 2:
                return perso;
            default:
                return perso + Main.ANSI_RESET;
        }
    }

    @Override
    public void redirect(Moving m) {
        m.getVelocity().reverse();
    }

    @Override
    public String toString() {
        return ' ' + this.color + ' ';
    }
}