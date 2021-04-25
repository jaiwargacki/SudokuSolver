import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

/**
 * Main program for solving sudoku board.
 * @author Jai Wargacki
 */
public class SudokuSolver {

    /** Usage message for SudokuSolver class. */
    private static final String USAGE_MSG = """
            Usage: java SudokuSolver <filename>
            The file should contain the sudoku puzzle with 'X' where blanks appear.
            All characters that are not 'X' and digits 1-9 will be ignored.
            """;
    /** File not found message. */
    private static final String FILE_MSG = "Error: %s (No such file or directory)%n";
    /** Input puzzle message. */
    private static final String INPUT_MSG = "Input puzzle :";
    /** Solution message. */
    private static final String SOL_MSG = "Solution to puzzle :";
    /** No solution message. */
    private static final String NO_SOL_MSG = "No solution found.";

    /**
     * Main method of the SudokuSolver program.
     * @param args file name containing the sudoku puzzle.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(USAGE_MSG);
            System.exit(1);
        }
        String filename = args[0];
        try {
            Scanner scanner = new Scanner(new File(filename));
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            scanner.close();
            SudokuBoard board = new SudokuBoard(stringBuilder.toString());
            Backtracker backtracker = new Backtracker();
            System.out.println(INPUT_MSG);
            System.out.println(board);
            Optional<Configuration> solution = backtracker.solve(board);
            if (solution.isPresent()) {
                System.out.println(SOL_MSG);
                System.out.println(solution.get());
            } else {
                System.out.println(NO_SOL_MSG);
            }

        } catch (FileNotFoundException e) {
            System.err.printf(FILE_MSG, filename);
        }
    }
}
