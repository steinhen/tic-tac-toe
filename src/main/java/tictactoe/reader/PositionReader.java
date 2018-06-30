package tictactoe.reader;

import tictactoe.Board;

public interface PositionReader {
    int[] getPosition(Board board) throws RuntimeException;
}
