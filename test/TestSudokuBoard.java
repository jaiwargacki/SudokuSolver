import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void test_isValid_1() {
        String input = "53XX7XXXX6XX195XXXX98XXXX6X8XXX6XXX34XX8X" +
                "3XX17XXX2XXX6X6XXXX28XXXX419XX5XXXX8XX79";
        SudokuBoard board = new SudokuBoard(input);
        boolean excepted = board.isValid();
        assertTrue(excepted);
    }
    @Test
    public void test_isValid_2() {
        String input = "537X7XXXX6XX195XXXX98XXXX6X8XXX6XXX34XX8X" +
                "3XX17XXX2XXX6X6XXXX28XXXX419XX5XXXX8XX79";
        SudokuBoard board = new SudokuBoard(input);
        boolean excepted = board.isValid();
        assertFalse(excepted);
    }
    @Test
    public void test_isValid_3() {
        String input = "53XX7XXX36XX195XXXX98XXXX6X8XXX6XXX34XX8X" +
                "3XX17XXX2XXX6X6XXXX28XXXX419XX5XXXX8XX79";
        SudokuBoard board = new SudokuBoard(input);
        boolean excepted = board.isValid();
        assertFalse(excepted);
    }
    @Test
    public void test_isValid_4() {
        String input = "53XX7XXXX6XX195XXXX98XXXX6X8XXX6XXX34XX8X" +
                "3XX17XXX2XXX6X6XXXX28XXXX419X95XXXX8XX79";
        SudokuBoard board = new SudokuBoard(input);
        boolean excepted = board.isValid();
        assertFalse(excepted);
    }
    @Test
    public void test_isValid_5() {
        String input = "827154396965327148341689752593468271472513" +
                "689618972435786235914154796823239841567";
        SudokuBoard board = new SudokuBoard(input);
        boolean excepted = board.isValid();
        assertTrue(excepted);
    }

    // Test isGoal
    @Test
    public void test_isGoal_1() {
        String input = "827154396965327148341689752593468271472513" +
                "689618972435786235914154796823239841567";
        SudokuBoard board = new SudokuBoard(input);
        boolean excepted = board.isGoal();
        assertTrue(excepted);
    }
    @Test
    public void test_isGoal_2() {
        String input = "827154396965327148341689752593468271472513" +
                "689618972435X86235914154796823239841567";
        SudokuBoard board = new SudokuBoard(input);
        boolean excepted = board.isGoal();
        assertFalse(excepted);
    }
    @Test
    public void test_isGoal_3() {
        String input = "827154396965327148341689752593468271472513" +
                "689618972438786235914154796823239841567";
        SudokuBoard board = new SudokuBoard(input);
        boolean excepted = board.isGoal();
        assertFalse(excepted);
    }

    // Test getSuccessors
}
