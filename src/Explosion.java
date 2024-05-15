public class Explosion extends Occupant{
    private static final String EXPLOSION = "\u2739";

    private boolean alreadyShowed;

    public Explosion(Grid grid, Position position) {
        super(grid, position);
        this.alreadyShowed = false;
    }

    public void destroy() {
        getGrid().removeAtPosition(getPosition());
    }

    @Override
    public void redirect(Moving m) {
        m.getVelocity().reverse();
    }

    @Override
    public String toString() {
        if (alreadyShowed) {
            destroy();
        }
        this.alreadyShowed = true;
        return ' ' + EXPLOSION + ' ';
    }
}
