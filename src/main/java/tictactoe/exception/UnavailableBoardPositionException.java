package tictactoe.exception;

public class UnavailableBoardPositionException extends RuntimeException {
    private static final String CANNOT_MARK_THIS_POSITION_MESSAGE = "Cannot mark this position.";

    public UnavailableBoardPositionException() {
        super(CANNOT_MARK_THIS_POSITION_MESSAGE);
    }
}
