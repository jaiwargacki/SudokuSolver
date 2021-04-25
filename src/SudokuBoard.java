import java.util.Collection;

/**
 * Configuration representing a sudoku board.
 * @author Jai Wargacki
 */
public class SudokuBoard implements Configuration {

    /**
     * Gets the successors of this sudoku board.
     * @return a collection of this sudoku board's successors.
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        return null;
    }

    /**
     * Determines if this sudoku board is valid.
     * @return true if the sudoku board is valid, false otherwise.
     */
    @Override
    public boolean isValid() {
        return false;
    }

    /**
     * Determines if this sudoku board is the goal.
     * @return true if the sudoku board is goal, false otherwise.
     */
    @Override
    public boolean isGoal() {
        return false;
    }
}
