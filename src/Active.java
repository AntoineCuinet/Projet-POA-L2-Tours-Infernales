/**
 * Represents an interface for objects that have to execute a process in each round.
 */
public interface Active {
    /**
     * The process to execute each round.
     */
    void update();
}
