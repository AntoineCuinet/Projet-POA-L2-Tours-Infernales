public class Border extends Occupant {
    private boolean horizontal;
    private boolean vertical;

    private static final String mur = Main.ANSI_RED + "\u2588" + Main.ANSI_RESET;
    private static final String murBas = Main.ANSI_RED + "\u2584" + Main.ANSI_RESET;
    private static final String murHaut = Main.ANSI_RED + "\u2580" + Main.ANSI_RESET;

    public Border(Grid grid, Position pos, boolean horizontal, boolean vertical) {
        super(grid, pos);
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    @Override
    public void redirect(Moving m) {
        m.getVelocity().rebond(horizontal, vertical);
    }

    @Override
    public String toString() {
        return mur;
    }
}
