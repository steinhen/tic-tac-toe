package tictactoe.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidatorTest {

    @Test
    public void isValidString() {
        InputValidator inputStringValidator = new InputValidator();
        assertTrue(inputStringValidator.isValidString("1,1"));
        assertTrue(inputStringValidator.isValidString("10,10"));
        assertFalse(inputStringValidator.isValidString("-1,-1"));
        assertFalse(inputStringValidator.isValidString("aaa"));
        assertFalse(inputStringValidator.isValidString("10, 10a"));
        assertFalse(inputStringValidator.isValidString("a10,10"));
    }
}