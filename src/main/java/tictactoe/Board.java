package tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tictactoe.exception.InvalidBoardPositionException;
import tictactoe.exception.InvalidBoardSizeException;
import tictactoe.exception.UnavailableBoardPositionException;

import java.util.Arrays;

/**
 * This class represents the abstraction of the board. It encapsulates the board matrix with the rules and methods to
 * handle and interact with it.
 */
@Component
public class Board {

    private static final int MIN_BOARD_SIZE = 3;
    private static final int MAX_BOARD_SIZE = 10;

    private Character[][] board;

    /**
     * Constructor that enforces the board size is within the range of board size allowed.
     *
     * @param size board size.
     */
    @Autowired
    public Board(@Value("${boardSize}") int size) {
        validateBoardSize(size);
        this.board = new Character[size][size];
        init();
    }

    private void validateBoardSize(int size) {
        if (MIN_BOARD_SIZE > size || size > MAX_BOARD_SIZE) {
            throw new InvalidBoardSizeException();
        }
    }

    private void init() {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Retrieves the board size.
     *
     * @return board size.
     */
    public int getSize() {
        return this.board.length;
    }

    public Character getCell(int x, int y) {
        return this.board[x][y];
    }

    /**
     * Places the given char c on the board place represented by the x and y parameters .
     *
     * @param x horizontal index.
     * @param y vertical index.
     * @param c character to be paced.
     */
    public void mark(int x, int y, char c) {
        checkValidPosition(x);
        checkValidPosition(y);
        checkPositionAvailability(x, y);
        board[x][y] = c;
    }

    private void checkPositionAvailability(int x, int y) {
        if (board[x][y] != ' ') {
            throw new UnavailableBoardPositionException();
        }
    }

    private void checkValidPosition(int position) {
        if (position < 0 || position >= board.length) {
            throw new InvalidBoardPositionException();
        }
    }

    boolean isBoardFull() {
        return Arrays.stream(this.board)
                .flatMap(Arrays::stream)
                .noneMatch(character -> character == ' ');
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Board:\n");
        for (int y = 0; y < board.length; y++) {
            sb.append('|');
            for (int x = 0; x < board.length; x++) {
                sb.append(board[x][y]).append('|');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
