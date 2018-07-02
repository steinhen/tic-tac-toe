package tictactoe.reader;

import tictactoe.Board;
import tictactoe.exception.UnableToReadPositionException;
import tictactoe.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Implementations of the position reader for human players. It gets the play/move of the player.
 */
public class PlayerPositionReader implements PositionReader {

    private InputValidator validator;
    private BufferedReader bufferedReader;

    /**
     * Constructor
     *
     * @param bufferedReader reader where to get the input string from.
     * @param validator      validator for the input string.
     */
    public PlayerPositionReader(BufferedReader bufferedReader, InputValidator validator) {
        this.validator = validator;
        this.bufferedReader = bufferedReader;
    }

    /**
     * Gets from the buffer reader the x and y pointing to the position on the board for the play.
     *
     * @param board board
     * @return Array of int, with x and y for the players play. containing x in index 0, and y in index 1.
     * @throws UnableToReadPositionException in case its not able to read string from the reader.
     */
    @Override
    public int[] getPosition(final Board board) throws UnableToReadPositionException {
        String[] split = readValidString().split(",");
        return new int[]{Integer.valueOf(split[0]), Integer.valueOf(split[1])};
    }

    private String readValidString() throws UnableToReadPositionException {
        String s;
        do {
            s = readLine();
        } while (!validator.isValidString(s));
        return s;
    }

    private String readLine() throws UnableToReadPositionException {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new UnableToReadPositionException();
        }
    }
}
