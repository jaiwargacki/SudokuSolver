import java.util.Collection;

/**
 * A configuration interface that the Backtracker class solves.
 * @author Jai Wargacki
 */
public interface Configuration {

    /**
     * Gets the successors of this configuration.
     * @return a collection of this configurations successors.
     */
    Collection<Configuration> getSuccessors();

    /**
     * Determines if this configuration is valid.
     * @return true if the configuration is valid, false otherwise.
     */
    boolean isValid();

    /**
     * Determines if this configuration is the goal.
     * @return true if the configuration is goal, false otherwise.
     */
    boolean isGoal();
}