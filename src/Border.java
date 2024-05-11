public class Border extends Occupant {
    private boolean horizontal;
    private boolean vertical;

    private static final String mur = Color.red() + "\u2588" + Color.reset();
    private static final String murBas = Color.red() + "\u2584" + Color.reset();
    private static final String murHaut = Color.red() + "\u2580" + Color.reset();

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
        if (vertical && !horizontal) {
            return mur;
        } else if (horizontal && getPosition().y() == 0) {
            return murHaut + murHaut + murHaut + murHaut;
        } else {
            return murBas + murBas + murBas + murBas;
        }
    }
}
