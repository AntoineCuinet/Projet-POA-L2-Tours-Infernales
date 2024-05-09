public class Border extends Occupant {
    private static final String mur = Main.ANSI_RED + "\u2588" + Main.ANSI_RESET;
    private static final String murBas = Main.ANSI_RED + "\u2584" + Main.ANSI_RESET;
    private static final String murHaut = Main.ANSI_RED + "\u2580" + Main.ANSI_RESET;

    public Border(Grid grid) {
        super(grid);
    }

    @Override
    public void redirect(Moving m) {
        m.getVelocity().rebond();
    }

    @Override
    public String toString() {
        return mur;
    }
}
