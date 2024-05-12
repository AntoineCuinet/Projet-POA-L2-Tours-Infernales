import java.util.HashSet;
import java.util.Set;

public class Perso extends Moving implements Comparable<Perso> {
    private static final String PERSO = "\u263A";

    private static int nbrPlayer = 0;

    private String color;
    private Set<Tower> ownedTowers;

    public Perso(Grid grid, Position position, Direction direction) {
        super(grid, position, direction);
        this.color = Color.array()[nbrPlayer % Color.array().length];
        this.ownedTowers = new HashSet<Tower>();
        nbrPlayer++;
    }

    public Perso(Grid grid, Position position) {
        this(grid, position, Direction.randomDirection());
    }

    public String getColor() {
        return this.color;
    }

    public boolean takeTower(Tower tower) {
        return this.ownedTowers.add(tower);
    }

    public boolean leaveTower(Tower tower) {
        return this.ownedTowers.remove(tower);
    }

    public Set<Tower> getOwnedTowers() {
        return this.ownedTowers;
    }

    public void update() {
        moveTo(getTargetPosition());
    }

    @Override
    public void redirect(Moving m) {
        m.getVelocity().reverse();
    }

    @Override
    public String toString() {
        return ' ' + this.color + PERSO + Color.reset() + ' ';
    }

    @Override
    public int compareTo(Perso other) {
        return this.ownedTowers.size() - other.ownedTowers.size();
    }
}