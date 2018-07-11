package tictactoe.util;

import org.junit.Test;
import tictactoe.Board;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExtendedCheckerTest {

    @Test
    public void findWinner_ShouldReturnTrue_whenAllCornersAreTakenBySamePlayer() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(2, 2, 'X');
        board.mark(2, 0, 'X');
        board.mark(0, 2, 'X');
        assertTrue(new ExtendedChecker().findWinner(board));
    }

    @Test
    public void findWinner_shouldReturnFalse_whenCornersAreEmpty() {
        assertFalse(new ExtendedChecker().findWinner(new Board(3)));
    }

    @Test
    public void findWinner_shouldReturnFalse_whenCornersAreTakenByDifferentPlayers() {
        assertFalse(new ExtendedChecker().findWinner(new Board(3)));
    }
}