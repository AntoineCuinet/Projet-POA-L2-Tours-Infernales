import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a tower within the game environment.
 */
public class Tower {
    private static final String FLOOR = "\u2580";
    private static final String WALL = "\u2588";
    private static final String CEIL = "\u25A1";
    private static final String OWNED_CEIL = "\u25A3";

    private static int nbrTower = 0; // Number of towers created

    private int num;
    private Ceil ceil;
    private int height;
    private Perso owner;
    private Set<Occupant> occupantsIndoor;

    /**
     * Constructs a new Tower object with the specified grid and maximum height.
     *
     * @param grid      The grid in which the tower will be placed.
     * @param maxHeight The maximum height of the tower.
     */
    public Tower(Grid grid, int maxHeight) throws NotEnoughPlaceException {
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
        Position floorPos = grid.randomEmptyPosition();
        new Floor(grid, floorPos, this);
        // get a random height
        this.height = (int)(Math.random() * maxHeight) + 1;
        Position ceilPos = new Position(floorPos.x(), floorPos.y(), this.height+1);
        this.ceil = new Ceil(grid, ceilPos, this);
    }

    /**
     * Gets the position of the last stage of the tower.
     *
     * @return The position of the last stage.
     */
    public Position getLastStage() {
        Position ceilPos = this.ceil.getPosition();
        return new Position(ceilPos.x(), ceilPos.y(), ceilPos.z() - 1);
    }

    /**
     * Adds an occupant to the tower.
     *
     * @param player The occupant to add.
     */
    public void occupantIn(Occupant player) {
        this.occupantsIndoor.add(player);
    }

    /**
     * Removes an occupant from the tower.
     *
     * @param player The occupant to remove.
     */
    public void occupantOut(Occupant player) {
        this.occupantsIndoor.remove(player);
    }

    /**
     * Checks if the tower is empty (has no occupants).
     *
     * @return True if the tower is empty, otherwise false.
     */
    public boolean isEmpty() {
        return this.occupantsIndoor.isEmpty();
    }

    /**
     * Gets the owner of the tower.
     *
     * @return The owner of the tower, null if the tower isn't owned.
     */
    public Perso getOwner() {
        return this.owner;
    }

    /**
     * Sets the owner of the tower.
     *
     * @param newOwner The new owner of the tower.
     */
    public void setOwner(Perso newOwner) {
        if (isOwned()) {
            this.owner.leaveTower(this);
        }
        if (newOwner != null) {
            newOwner.takeTower(this);
        }
        this.owner = newOwner;
    }

    /**
     * Checks if the tower is owned by a player.
     *
     * @return True if the tower is owned, otherwise false.
     */
    public boolean isOwned() {
        return (this.owner != null);
    }

    /**
     * Checks if the tower is free for teleportation (last stage is empty).
     *
     * @return True if the tower is free for teleportation, otherwise false.
     */
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

    /**
     * Returns a string representation of the tower.
     *
     * @return The string representation of the tower.
     */
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

    /**
     * Returns a list of towers that are free for teleportation from the given collection.
     *
     * @param towersList The collection of towers to check.
     * @return A list of towers that are free for teleportation.
     */
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
