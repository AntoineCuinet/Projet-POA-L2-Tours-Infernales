import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tower {
    private static final String FLOOR = "\u2580";
    private static final String WALL = "\u2588";
    private static final String CEIL = "\u25A1";
    private static final String OWNED_CEIL = "\u25A3";

    private static int nbrTower = 0;

    private int num;
    private Ceil ceil;
    private int height;
    private Perso owner;
    private Set<Occupant> occupantsIndoor;

    public Tower(Grid grid, int maxHeight) {
        this.occupantsIndoor = new HashSet<Occupant>();
        this.owner = null;
        // get index
        nbrTower++;
        this.num = nbrTower;
        // check max height validity
        if (maxHeight < 1) {
            maxHeight = 1;
        }
        // determine position
        Position floorPos = grid.randomFreePosition();
        new Floor(grid, floorPos, this);
        // get a random height
        this.height = (int)(Math.random() * maxHeight) + 1;
        Position ceilPos = new Position(floorPos.x(), floorPos.y(), this.height+1);
        this.ceil = new Ceil(grid, ceilPos, this);
    }

    public Position getLastStage() {
        Position ceilPos = this.ceil.getPosition();
        return new Position(ceilPos.x(), ceilPos.y(), ceilPos.z() - 1);
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

    public Perso getOwner() {
        return this.owner;
    }

    public void setOwner(Perso newOwner) {
        if (isOwned()) {
            this.owner.leaveTower(this);
        }
        newOwner.takeTower(this);
        this.owner = newOwner;
    }

    public boolean isOwned() {
        return (this.owner != null);
    }

    public boolean freeToTeleport() {
        // the last stage must be empty
        for (Occupant occ : this.occupantsIndoor) {
            if (occ.getPosition().z() == this.height) {
                return false;
            }
        }
        // free
        return true;
    }

    @Override
    public String toString() {
        // head
        String dst = "Tour " + String.valueOf(this.num);
        if (isOwned()) {
            dst += " [" + getOwner() + "]";
        }
        dst += '\n';
        // graphical representation
        if (isOwned()) {
            dst += " " + this.owner.getColor() + OWNED_CEIL + OWNED_CEIL + OWNED_CEIL + Color.reset() + " \n";
        }
        else {
            dst += " " + CEIL + CEIL + CEIL + " \n";
        }
        for (int i=this.height ; i > 0 ; i--) {
            String stage = WALL + "   " + WALL;
            for (Occupant occ : this.occupantsIndoor) {
                if (occ.getPosition().z() == i) {
                    stage = WALL + occ + WALL;
                }
            }
            dst += stage + "\n";
        }
        dst += FLOOR + FLOOR + FLOOR + FLOOR + FLOOR + "\n";
        return dst;
    }

    public static List<Tower> towersFreeToTeleport(Collection<Tower> towersList) {
        List<Tower> freeList = new ArrayList<Tower>();
        for (Tower tower : towersList) {
            if (tower.freeToTeleport()) {
                freeList.add(tower);
            }
        }
        return freeList;
    }
}
