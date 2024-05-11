import java.util.HashSet;
import java.util.Set;

public class Tower {
    private Floor floor;
    private Ceil ceil;
    private int height;
    private Set<Occupant> occupantsIndoor;

    public Tower(Grid grid, int maxHeight) {
        this.occupantsIndoor = new HashSet<Occupant>();
        // check max height validity
        if (maxHeight < 1) {
            maxHeight = 1;
        }
        // determine position
        Position floorPos = grid.randomFreePosition();
        this.floor = new Floor(grid, floorPos, this);
        // get a random height
        this.height = (int)(Math.random() * maxHeight) + 1;
        Position ceilPos = new Position(floorPos.x(), floorPos.y(), this.height+1);
        this.ceil = new Ceil(grid, ceilPos, this);
    }

    public void occupantIn(Occupant player) {
        this.occupantsIndoor.add(player);
    }

    public void occupantOut(Occupant player) {
        this.occupantsIndoor.remove(player);
    }

    public boolean isEmpty() {
        return this.occupantsIndoor.isEmpty();
    }

    @Override
    public String toString() {
        String dst = "Tour\n#\n";
        for (int i=this.height ; i > 0 ; i--) {
            String icon = "|\n";
            for (Occupant occ : this.occupantsIndoor) {
                if (occ.getPosition().z() == i) {
                    icon = occ + "\n";
                }
            }
            dst += icon;
        }
        dst += "#\n";
        return dst;
    }
}
