public class Border extends Occupant {
    private String mur = Main.ANSI_RED + "\u2588" + Main.ANSI_RESET;
    private String murBas = Main.ANSI_RED + "\u2584" + Main.ANSI_RESET;
    private String murHaut = Main.ANSI_RED + "\u2580" + Main.ANSI_RESET;

    public Border(Grid grid) {
        super(grid);
        //TODO Auto-generated constructor stub
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
