package tictactoe.util;

import org.junit.Test;
import tictactoe.Board;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WinnerCheckerTest {

    private static final char CHAR = 'X';

    @Test
    public void findWinner_shouldReturnFalse_whenThereIsNoWinner() {
        Board board = new Board();
        board.mark(0, 0, CHAR);
        WinnerChecker checker = new WinnerChecker();
        assertFalse(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnTrue_whenRowPositionsHaveSameChar() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            board.mark(1, i, CHAR);
        }
        WinnerChecker checker = new WinnerChecker();
        assertTrue(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnTrue_whenColumnPositionsHaveSameChar() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            board.mark(i, 1, CHAR);
        }
        WinnerChecker checker = new WinnerChecker();
        assertTrue(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnTrue_whenDiagonal1PositionsHaveSameChar() {
        Board board = new Board();
        board.mark(0, 0, CHAR);
        board.mark(1, 1, CHAR);
        board.mark(2, 2, CHAR);
        WinnerChecker checker = new WinnerChecker();
        assertTrue(checker.findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnTrue_whenDiagonal2PositionsHaveSameChar() {
        Board board = new Board();
        board.mark(0, 2, CHAR);
        board.mark(1, 1, CHAR);
        board.mark(2, 0, CHAR);
        WinnerChecker checker = new WinnerChecker();
        assertTrue(checker.findWinner(board));
    }

}