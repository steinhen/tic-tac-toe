package tictactoe.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Enter a position again.";

    public InputValidator() {
    }

    public boolean isValidString(String s) {
        //Todo starts with number
        boolean valid = Pattern.compile("\\d{1,2},\\d{1,2}").matcher(s).find();
        if (!valid) {
            System.out.println(INVALID_INPUT_MESSAGE);
        }
        return valid;
    }
}
