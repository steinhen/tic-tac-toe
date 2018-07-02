package tictactoe.exception;

public class UnableToReadPositionException extends Exception {

    private static final String COULD_NOT_READ_POSITION_MESSAGE = "Couldn't read position.";

    public UnableToReadPositionException() {
        super(COULD_NOT_READ_POSITION_MESSAGE);
    }
}
