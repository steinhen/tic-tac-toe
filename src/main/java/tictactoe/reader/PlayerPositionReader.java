package tictactoe.reader;

import tictactoe.Board;
import tictactoe.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;

public class PlayerPositionReader implements PositionReader {

    private InputValidator validator;
    private BufferedReader bufferedReader;

    public PlayerPositionReader(BufferedReader bufferedReader, InputValidator validator) {
        this.validator = validator;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String[] getPositions(final Board board) {
        return readPosition().split(",");
    }

    private String readPosition() {
        String s;
        do {
            s = readLine();
        } while (!validator.isValidString(s));
        return s;
    }

    private String readLine() {
        String s;
        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
            s = "";
        }
        return s;
    }
}
