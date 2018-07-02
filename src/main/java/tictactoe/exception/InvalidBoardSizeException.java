package tictactoe.exception;

public class InvalidBoardSizeException extends RuntimeException {
    private static final String INVALID_BOARD_SIZE_MESSAGE = "Invalid board size";

    public InvalidBoardSizeException() {
        super(INVALID_BOARD_SIZE_MESSAGE);
    }
}
