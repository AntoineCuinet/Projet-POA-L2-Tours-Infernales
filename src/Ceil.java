import java.util.List;

public class Ceil extends Occupant {
    private Tower tower;

    public Ceil(Grid grid, Position position, Tower tower) {
        super(grid, position);
        this.tower = tower;
    }

    @Override
    public void redirect(Moving m) {
        // choose between reverse dir and teleportation
        boolean teleportation = (int)(Math.random()*2) == 1;
        // teleportation case (verify if m is a player)
        if (teleportation && m instanceof Perso) {
            List<Tower> freeTowers = Tower.towersFreeToTeleport((Perso)m);
            if (!freeTowers.isEmpty()) {
                // choose a random tower and teleport to it
                Tower targetTower = freeTowers.get((int)(Math.random() * freeTowers.size()));
                m.setPosition(targetTower.getLastStage());
                this.tower.occupantOut(m);
                targetTower.occupantIn(m);
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
