package tictactoe.reader;

import tictactoe.Board;
import tictactoe.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;

public class PlayerPositionReader implements PositionReader {

    private static final String COULD_NOT_READ_FROM_POSITION_MESSAGE = "Couldn't read from position.";

    private InputValidator validator;
    private BufferedReader bufferedReader;

    public PlayerPositionReader(BufferedReader bufferedReader, InputValidator validator) {
        this.validator = validator;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public int[] getPosition(final Board board) throws RuntimeException {
        String[] split = readValidString().split(",");
        return new int[]{Integer.valueOf(split[0]), Integer.valueOf(split[1])};
    }

    private String readValidString() throws RuntimeException {
        String s;
        do {
            s = readLine();
        } while (!validator.isValidString(s));
        return s;
    }

    private String readLine() throws RuntimeException {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(COULD_NOT_READ_FROM_POSITION_MESSAGE);
        }
    }
}
