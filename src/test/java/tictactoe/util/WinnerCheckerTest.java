package tictactoe.util;

import org.junit.Test;
import tictactoe.Board;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WinnerCheckerTest {

    private static final char X_CHAR = 'X';
    private static final char O_CHAR = 'O';

    @Test
    public void findWinner_shouldReturnFalse_whenThereIsNoWinner() {
        Board board = new Board(3);
        board.mark(0, 0, X_CHAR);
        WinnerChecker checker = new WinnerChecker();
        assertFalse(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnTrue_whenRowPositionsHaveSameChar() {
        Board board = new Board(3);
        board.mark(0, 0, X_CHAR);
        board.mark(0, 1, O_CHAR);
        for (int i = 0; i < 3; i++) {
            board.mark(1, i, X_CHAR);
        }
        WinnerChecker checker = new WinnerChecker();
        assertTrue(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnTrue_whenColumnPositionsHaveSameChar() {
        Board board = new Board(3);
        board.mark(0, 0, X_CHAR);
        board.mark(1, 0, O_CHAR);
        for (int i = 0; i < 3; i++) {
            board.mark(i, 1, X_CHAR);
        }
        WinnerChecker checker = new WinnerChecker();
        assertTrue(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnTrue_whenDiagonal1PositionsHaveSameChar() {
        Board board = new Board(3);
        board.mark(0, 0, X_CHAR);
        board.mark(1, 1, X_CHAR);
        board.mark(2, 2, X_CHAR);
        WinnerChecker checker = new WinnerChecker();
        assertTrue(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnTrue_whenDiagonal2PositionsHaveSameChar() {
        Board board = new Board(3);
        board.mark(0, 2, X_CHAR);
        board.mark(1, 1, X_CHAR);
        board.mark(2, 0, X_CHAR);
        WinnerChecker checker = new WinnerChecker();
        assertTrue(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnFalse_whenDiagonalsDoNotHaveSameChar() {
        Board board = new Board(3);
        board.mark(0, 0, X_CHAR);
        board.mark(1, 1, O_CHAR);
        board.mark(0, 2, X_CHAR);
        WinnerChecker checker = new WinnerChecker();
        assertFalse(checker.findWinner(board));
    }

}