import java.util.List;

/**
 * Represents a ceiling object of a tower in a grid.
 */
public class Ceil extends Occupant {
    private Tower tower;

    /**
     * Constructs a new Ceil object with the specified parameters.
     *
     * @param grid     The grid in which the ceiling exists.
     * @param position The position of the ceiling in the grid.
     * @param tower    The tower who own the ceiling.
     */
    public Ceil(Grid grid, Position position, Tower tower) {
        super(grid, position);
        this.tower = tower;
    }

    /**
     * Redirects the movement of an object when it encounters the ceiling.
     *
     * @param m The object whose movement needs to be redirected.
     */
    @Override
    public void redirect(Moving m) {
        // choose between reverse dir and teleportation
        boolean teleportation = (int)(Math.random()*2) == 1;
        // teleportation case (verify if m is a player)
        if (teleportation && m instanceof Perso) {
            Perso player = (Perso)m;
            List<Tower> freeTowers = Tower.towersFreeToTeleport(player.getOwnedTowers());
            if (!freeTowers.isEmpty()) {
                // choose a random tower and teleport to it
                Tower targetTower = freeTowers.get((int)(Math.random() * freeTowers.size()));
                player.setPosition(targetTower.getLastStage());
                this.tower.occupantOut(player);
                targetTower.occupantIn(player);
            }
        }
        // revert direction
        m.getVelocity().reverse(); // this process has to be executing in all cases
        // if it's a player, define it as the tower's owner
        if (m instanceof Perso) {
            this.tower.setOwner((Perso)m);
        }
    }
}
