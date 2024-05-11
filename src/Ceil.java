public class Ceil extends Occupant {
    private Tower tower;

    public Ceil(Grid grid, Position position, Tower tower) {
        super(grid, position);
        this.tower = tower;
    }

    @Override
    public void redirect(Moving m) {
        // TODO: à refaire
        m.getVelocity().reverse();
    }
}
