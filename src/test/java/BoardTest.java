import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BoardTest {

    private static final char CHAR = 'X';

    @Test(expected = RuntimeException.class)
    public void mark_shouldThrowException_whenXIsLowerThan0() {
        Board board = new Board();
        board.mark(-1, 0, CHAR);
    }

    @Test(expected = RuntimeException.class)
    public void mark_shouldThrowException_whenXIsGreaterThanBoardSize() {
        Board board = new Board();
        board.mark(4, 0, CHAR);
    }

    @Test(expected = RuntimeException.class)
    public void mark_shouldThrowException_whenYIsLowerThan0() {
        Board board = new Board();
        board.mark(0, -1, CHAR);
    }

    @Test(expected = RuntimeException.class)
    public void mark_shouldThrowException_whenYIsGreaterThanBoardSize() {
        Board board = new Board();
        board.mark(0, 4, CHAR);
    }

    @Test
    public void mark_shouldNotThrowException_whenPositionIsWithinTheRange() {
        Board board;
        try {
            board = new Board();
            board.mark(0, 0, CHAR);
        } catch (Exception e) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void mark_shouldThrowException_whenMarkingPositionAlreadyTaken() {
        Board board = new Board();
        board.mark(0, 0, CHAR);
        board.mark(0, 0, CHAR);
    }

    @Test
    public void constructor_shouldAllowPassBoardSize() {
        Board board;
        try {
            board = new Board(10);
            board.mark(9, 9, CHAR);
        } catch (Exception e) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void constructor_shouldThrowException_whenBoardSizeIsMoreThan10() {
        new Board(11);
    }

    @Test(expected = RuntimeException.class)
    public void constructor_shouldThrowException_whenBoardSizeIsSmallerThan3() {
        new Board(2);
    }

    @Test
    public void isBoardFull_shouldReturnTrue_whenThereIsNoMoreEmptyPosition() {
        Board board = new Board();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.mark(i, j, CHAR);
            }
        }
        assertTrue(board.isBoardFull());
    }

    @Test
    public void isBoardFull_shouldReturnFalse_whenThereIsEmptyPosition() {
        Board board = new Board();
        board.mark(0, 0, CHAR);
        assertFalse(board.isBoardFull());
    }

}
