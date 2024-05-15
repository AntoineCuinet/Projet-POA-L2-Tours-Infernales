public class Snowman extends Occupant {
    private static final String SNOWMAN = "\u26C7";

    public Snowman(Grid grid, Position position) {
        super(grid, position);
    }

    @Override
    public void redirect(Moving m) {
        // freeze player
        if (m instanceof Perso) {
            Perso player = (Perso)m;
            player.freeze();
        }
        // kill itself
        getGrid().removeAtPosition(getPosition());
    }

    @Override
    public String toString() {
        return ' ' + SNOWMAN + ' ';
    }
}
