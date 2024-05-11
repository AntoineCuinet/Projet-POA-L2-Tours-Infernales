public class Floor extends Occupant {

    private static final String tour = "\u25A1";
    private static final String tourPleine = "\u25A3";

    public Floor(Grid grid, Position position) {
        super(grid, position);
    }

    @Override
    public String toString() {
        return ' ' + tour + ' ';
    }

    @Override
    public void redirect(Moving m) {
        // TODO à refaire
        m.getVelocity().reverse();
    }
}
