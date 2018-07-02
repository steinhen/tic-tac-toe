package tictactoe.reader;

import org.springframework.stereotype.Component;
import tictactoe.Board;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Implementations of the position reader for computer players. It gets the play/move of the computer.
 */
@Component
public class ComputerPositionReader implements PositionReader {

    /**
     * Gets the x and y pointing to the position on the board for the computer play. Generates random indexes within
     * the range (board size).
     *
     * @param board board
     * @return Array of int, with x and y for the players play. containing x in index 0, and y in index 1.
     */
    @Override
    public int[] getPosition(Board board) {
        return new int[]{
                ThreadLocalRandom.current().nextInt(0, board.getSize()),
                ThreadLocalRandom.current().nextInt(0, board.getSize())
        };
    }

}
