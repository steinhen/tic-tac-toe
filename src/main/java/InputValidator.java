import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InputValidator {

    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Enter a position again.";

    InputValidator() {
    }

    boolean isValidString(String s) {
        Pattern pattern = Pattern.compile("\\d{1,2},\\d{1,2}");
        Matcher matcher = pattern.matcher(s);
        boolean isValidString = matcher.find();
        if (!isValidString) {
            System.out.println(INVALID_INPUT_MESSAGE);
        }
        return isValidString;
    }
}
