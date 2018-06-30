package tictactoe.reader;

import tictactoe.Board;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerPositionReader implements PositionReader {

    @Override
    public int[] getPosition(Board board) throws RuntimeException {
        int x = ThreadLocalRandom.current().nextInt(0, board.getSize());
        int y = ThreadLocalRandom.current().nextInt(0, board.getSize());
        return new int[]{x, y};
    }

}
