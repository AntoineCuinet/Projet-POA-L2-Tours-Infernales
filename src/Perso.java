public class Perso extends Moving {
    private String perso = "\u263A";

    public Perso(Grid grid, Position position, Direction direction) {
        super(grid, position, direction);
    }


    @Override
    public void redirect(Moving m) {
        m.getVelocity().reverse();        
    }

    @Override
    public String toString() {
        return perso;
    }
}