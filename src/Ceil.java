public class Ceil extends Occupant{

    public Ceil(Grid grid, Position position) {
        super(grid, position);
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public void redirect(Moving m) {
        // TODO à refaire
        m.getVelocity().reverse();
    }
    
}
