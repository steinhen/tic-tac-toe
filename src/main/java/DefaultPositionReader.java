import java.io.BufferedReader;
import java.io.IOException;

class DefaultPositionReader {

    private InputValidator inputStringValidator;
    private BufferedReader bufferedReader;

    DefaultPositionReader(BufferedReader bufferedReader, InputValidator inputStringValidator) {
        this.inputStringValidator = inputStringValidator;
        this.bufferedReader = bufferedReader;
    }

    String[] getPositions() {
        return readPosition().split(",");
    }

    private String readPosition() {
        String s;
        do {
            s = readLine();
        } while (!inputStringValidator.isValidString(s));
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
