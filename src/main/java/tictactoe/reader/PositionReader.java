package tictactoe.reader;

import tictactoe.Board;

interface PositionReader {
    String[] getPositions(Board board);
}
