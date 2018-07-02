package tictactoe.exception;

public class InvalidBoardPositionException extends RuntimeException {

    private static final String INVALID_POSITION_MESSAGE = "Invalid Position.";

    public InvalidBoardPositionException() {
        super(INVALID_POSITION_MESSAGE);
    }
}
