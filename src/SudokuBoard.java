import java.util.Collection;

/**
 * Configuration representing a sudoku board.
 * @author Jai Wargacki
 */
public class SudokuBoard implements Configuration {

    /**
     * Constructor for sudoku board.
     * @param stringBoard string of sudoku board.
     *                    81 char (1-9 or X). X is used for blank space. Whitespace is ignored.
     */
    public SudokuBoard(String stringBoard) {

    }

    /**
     * Gets string version of the sudoku board.
     * @return string version of the sudoku board.
     */
    @Override
    public String toString() {
        return null;
    }

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
