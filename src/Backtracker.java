import java.util.Optional;

/**
 * Backtracker solves a provided configuration.
 * @author Jai Wargacki
 */
public class Backtracker {

    /**
     * Constructor for Backtracker class.
     */
    public Backtracker() {
        //empty
    }

    /**
     * Solve a given configuration.
     * @param config a configuration to solve.
     * @return the solution if solvable or Optional empty if no solution.
     */
    public Optional<Configuration> solve(Configuration config) {
        if (config.isGoal()) {
            return Optional.of(config);
        } else {
            for (Configuration child : config.getSuccessors()) {
                if (child.isValid()) {
                    Optional<Configuration> sol = solve(child);
                    if (sol.isPresent()) {
                        return sol;
                    }
                }
            }
        }
        return Optional.empty();
    }
}