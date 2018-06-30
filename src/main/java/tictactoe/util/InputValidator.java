package tictactoe.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Enter a position again.";

    public boolean isValidString(String s) {
        boolean valid = Pattern.compile("^(\\d{1,2},\\d{1,2})$").matcher(s).matches();
        if (!valid) {
            System.out.println(INVALID_INPUT_MESSAGE);
        }
        return valid;
    }
}
