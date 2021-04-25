import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Used to test sudoku boards.
 * @author Jai Wargacki
 */
@Testable
public class TestSudokuBoard {
    // Test toString
    @Test
    public void test_toString_1() {
        String input = """
                123456789
                123456789
                123456789
                123456789
                123456789
                123456789
                123456789
                123456789
                123456789
                """;
        SudokuBoard board = new SudokuBoard(input);
        String excepted = """
                123 456 789
                123 456 789
                123 456 789
                
                123 456 789
                123 456 789
                123 456 789
                
                123 456 789
                123 456 789
                123 456 789
                """;
        String actual = board.toString();
        assertEquals(excepted, actual);
    }
    @Test
    public void test_toString_2() {
        String input = """
                12  3456  789123  4567  89
                1  2345   6789
                12345  67891234   56789
                1  23456789
                1234  56789123   456789
                1  23456789
                """;
        SudokuBoard board = new SudokuBoard(input);
        String excepted = """
                123 456 789
                123 456 789
                123 456 789
                
                123 456 789
                123 456 789
                123 456 789
                
                123 456 789
                123 456 789
                123 456 789
                """;
        String actual = board.toString();
        assertEquals(excepted, actual);
    }
    @Test
    public void test_toString_3() {
        String input = """
                1234X6789
                123456789
                123456789
                123456789
                123456789
                123456X89
                123456789
                X23456789
                123456789
                """;
        SudokuBoard board = new SudokuBoard(input);
        String excepted = """
                123 4 6 789
                123 456 789
                123 456 789
                
                123 456 789
                123 456 789
                123 456  89
                
                123 456 789
                 23 456 789
                123 456 789
                """;
        String actual = board.toString();
        assertEquals(excepted, actual);
    }

    // Test isValid

    // Test isGoal

    // Test getSuccessors
}
