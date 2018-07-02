package tictactoe.util;

import java.util.regex.Pattern;

/**
 * Class that holds the rules for the input from the player.
 */
public class InputValidator {

    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Enter a position again.";

    /**
     * Checks if the given string is valid based on the rule that only digits are allowed and must be comma separated.
     * String must be in the format of "n,n", where n is a positive number up to 99.
     *
     * @param inputString input string to be validated.
     * @return True if string has 2 numbers with no more than 2 digits each and separated by a comma. False, otherwise.
     */
    public boolean isValidString(String inputString) {
        boolean valid = Pattern.compile("^(\\d{1,2},\\d{1,2})$").matcher(inputString).matches();
        if (!valid) {
            System.out.println(INVALID_INPUT_MESSAGE);
        }
        return valid;
    }
}
