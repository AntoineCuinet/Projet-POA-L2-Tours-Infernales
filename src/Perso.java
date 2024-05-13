import java.util.HashSet;
import java.util.Set;

/**
 * Represents a player character within a grid, capable of movement.
 * Extends the Moving class and implements the Comparable interface.
 */
public class Perso extends Moving implements Comparable<Perso> {
    private static final String PERSO = "\u263A";

    private static int nbrPlayer = 0; // Number of players created

    private String color;
    private Set<Tower> ownedTowers;

    /**
     * Constructs a new Perso object with the specified grid, position, and direction.
     *
     * @param grid      The grid in which the player character will be placed.
     * @param position  The initial position of the player character.
     * @param direction The initial direction of the player character's movement.
     */
    public Perso(Grid grid, Position position, Direction direction) {
        super(grid, position, direction);
        this.color = Color.array()[nbrPlayer % Color.array().length];
        this.ownedTowers = new HashSet<Tower>();
        nbrPlayer++;
    }

    /**
     * Constructs a new Perso object with the specified grid and position,
     * with a random initial direction.
     *
     * @param grid     The grid in which the player character exists.
     * @param position The initial position of the player character.
     */
    public Perso(Grid grid, Position position) {
        this(grid, position, Direction.randomDirection());
    }

    /**
     * Gets the color associated with the player character.
     *
     * @return The color associated with the player character.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Make the player taken control of a tower.
     *
     * @param tower The tower to take control of.
     * @return True if the tower has correctly added to owned towers list of the player, otherwise false.
     */
    public boolean takeTower(Tower tower) {
        return this.ownedTowers.add(tower);
    }

    /**
     * Make the player taken control of a tower.
     *
     * @param tower The tower to leave control of.
     * @return True if the tower has correctly removed to owned towers list of the player, otherwise false.
     */
    public boolean leaveTower(Tower tower) {
        return this.ownedTowers.remove(tower);
    }

    /**
     * Gets the set of towers owned by the player character.
     *
     * @return The set of towers owned by the player character.
     */
    public Set<Tower> getOwnedTowers() {
        return this.ownedTowers;
    }

    /**
     * Method that has to be executed in each rounds.
     * Updates the position of the player character based on its current direction.
     */
    public void update() {
        moveTo(getTargetPosition());
    }

    /**
     * Redirects the movement of another Moving object by reversing its direction.
     *
     * @param m The Moving object whose movement needs to be redirected.
     */
    @Override
    public void redirect(Moving m) {
        m.getVelocity().reverse();
    }

    /**
     * Returns a string representation of the player character.
     *
     * @return The string representation of the player character.
     */
    @Override
    public String toString() {
        return ' ' + this.color + PERSO + Color.reset() + ' ';
    }

    /**
     * Compares this player character to another based on the number of towers owned.
     *
     * @param other The other player character to compare to.
     * @return A negative integer, zero, or a positive integer as this player character
     *         has fewer, equal to, or more owned towers compared to the other.
     */
    @Override
    public int compareTo(Perso other) {
        return this.ownedTowers.size() - other.ownedTowers.size();
    }
}