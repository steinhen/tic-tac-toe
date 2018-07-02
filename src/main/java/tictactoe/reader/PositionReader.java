package tictactoe.reader;

import tictactoe.Board;
import tictactoe.exception.UnableToReadPositionException;

/**
 * Interface to get the player's play (the position where to place the player's character)
 */
public interface PositionReader {
    /**
     * Gets the x and y pointing to the position on the board for the computer play.
     *
     * @param board board
     * @return Array of int, where X is in index 0 and Y in index 1.
     * @throws RuntimeException when problems reading the position happen.
     */
    int[] getPosition(Board board) throws UnableToReadPositionException;
}
