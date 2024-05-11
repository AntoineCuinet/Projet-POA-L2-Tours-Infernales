import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tower {
    private int index;
    private Floor floor;
    private Ceil ceil;
    private int height;
    private Perso owner;
    private Set<Occupant> occupantsIndoor;

    private static List<Tower> towersList = new ArrayList<Tower>();

    public Tower(Grid grid, int maxHeight) {
        this.occupantsIndoor = new HashSet<Occupant>();
        this.owner = null;
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
        // add to tower list
        this.index = towersList.size();
        towersList.add(this);
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
        this.owner = newOwner;
    }

    public boolean isOwned() {
        return (this.owner != null);
    }

    public boolean freeToTeleport() {
        int lastStage = this.height;
        for (Occupant occ : this.occupantsIndoor) {
            if (occ.getPosition().z() == lastStage) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        // head
        String dst = "Tour " + String.valueOf(this.index+1);
        if (isOwned()) {
            dst += " [" + getOwner() + "]";
        }
        dst += '\n';
        // graphical representation
        dst += "#\n";
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

    public static List<Tower> towersFreeToTeleport() {
        List<Tower> freeList = new ArrayList<Tower>();
        for (Tower tower : towersList) {
            if (tower.freeToTeleport()) {
                freeList.add(tower);
            }
        }
        return freeList;
    }
}
