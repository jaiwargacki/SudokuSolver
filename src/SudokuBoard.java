import java.util.*;

/**
 * Configuration representing a sudoku board.
 * @author Jai Wargacki
 */
public class SudokuBoard implements Configuration {

    /** Valid digits (1-9). */
    private static final Set<Character> VALID_DIGITS =
            Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');
    /** Blank space input char. */
    private static final char BLANK_SPACE_INPUT_CHAR = 'X';
    /** Blank space char. */
    private static final char BLANK_SPACE_CHAR = ' ';
    /** Newline char. */
    private static final char NEWLINE_CHAR = '\n';


    /** 2D array of char representing sudoku board. */
    private final char[][] board;
    /** Counter to keep track of where next successors should be generated. */
    private int successorsCounter;

    /**
     * Sub class to act as char iterator for parsing input string.
     */
    private static class CharacterIterator implements Iterator<Character> {

        /** Input string to iterate over. */
        private final String str;
        /** The input string's length. */
        private final int len;
        /** Current position in string. */
        private int position;

        /**
         * Constructor for CharacterIterator.
         * @param str the string to iterate over.
         */
        public CharacterIterator(String str) {
            this.str = str;
            this.len = str.length();
            this.position = 0;
        }

        /**
         * Determine if there is another char in string.
         * @return true if there is another char in string, false otherwise.
         */
        public boolean hasNext() {
            return position < len;
        }

        /**
         * Get the next char.
         * @return the next char.
         */
        public Character next() {
            return str.charAt(position++);
        }

        /**
         * Remove is not supported by this class.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Constructor for sudoku board.
     * @param stringBoard string of sudoku board.
     *                    81 char (1-9 or X). X is used for blank space.
     *                    Whitespace and all other chars are ignored.
     * @throws IllegalArgumentException if not enough chars are provided.
     */
    public SudokuBoard(String stringBoard) throws IllegalArgumentException {
        this.board = new char[9][9];
        this.successorsCounter = 0;
        int counter = 0;
        char next;
        int row = 0;
        int col = 0;
        CharacterIterator iterator = new CharacterIterator(stringBoard);
        while (iterator.hasNext()) {
            next = iterator.next();
            if (VALID_DIGITS.contains(next)) {
                board[row][col] = next;
            } else if (next == BLANK_SPACE_INPUT_CHAR) {
                board[row][col] = BLANK_SPACE_CHAR;
            } else {
                continue;
            }
            counter++;
            row = Math.floorDiv(counter, 9);
            col = counter % 9;
        }
        if (counter != 81) {
            throw new IllegalArgumentException("Not enough characters provided.");
        }
    }

    /**
     * Constructor for sudoku board that makes a deep copy of another board.
     * @param other another sudoku board.
     */
    public SudokuBoard(SudokuBoard other) {
        this.board = new char[9][9];
        this.successorsCounter = other.successorsCounter + 1;
        int row;
        int col;
        for (int counter = 0; counter < 81; counter++) {
            row = Math.floorDiv(counter, 9);
            col = counter % 9;
            this.board[row][col] = other.board[row][col];
        }
    }

    /**
     * Gets string version of the sudoku board.
     * @return string version of the sudoku board.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int counter_1 = 0;
        for (char[] row : board) {
            int counter_2 = 0;
            for (char c : row) {
                s.append(c);
                counter_2++;
                if (counter_2 != 0 && counter_2 != 9 && counter_2 % 3 == 0) {
                    s.append(BLANK_SPACE_CHAR);
                }
            }
            s.append(NEWLINE_CHAR);
            counter_1++;
            if (counter_1 != 0 && counter_1 != 9 && counter_1 % 3 == 0) {
                s.append(NEWLINE_CHAR);
            }
        }
        return s.toString();
    }

    /**
     * Gets the successors of this sudoku board.
     * @return a collection of this sudoku board's successors.
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        // Find next place to generate successors.
        int row = Math.floorDiv(successorsCounter, 9);
        int col = successorsCounter % 9;
        while (board[row][col] != BLANK_SPACE_CHAR) {
            successorsCounter++;
            if (successorsCounter > 81) {
                return successors;
            } else {
                row = Math.floorDiv(successorsCounter, 9);
                col = successorsCounter % 9;
            }
        }
        // Generate 9 successors for the found location.
        for (char digit :VALID_DIGITS) {
            SudokuBoard successor = new SudokuBoard(this);
            successor.board[row][col] = digit;
            successors.add(successor);
        }
        return successors;
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
