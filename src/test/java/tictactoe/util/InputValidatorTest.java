package tictactoe.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidatorTest {

    private final InputValidator inputStringValidator = new InputValidator();

    @Test
    public void isValidString_shouldAllowOneDigitForEachIndex() {
        assertTrue(inputStringValidator.isValidString("1,1"));
    }

    @Test
    public void isValidString_shouldAllowTwoDigitsForEachIndex() {
        assertTrue(inputStringValidator.isValidString("10,10"));
    }

    @Test
    public void isValidString_shouldNotAllowThreeDigitsForIndex() {
        assertFalse(inputStringValidator.isValidString("100,10"));
    }

    @Test
    public void isValidString_shouldNotAllowNegativeNumbers() {
        assertFalse(inputStringValidator.isValidString("-1,-1"));
    }

    @Test
    public void isValidString_shouldNotAllowLetters() {
        assertFalse(inputStringValidator.isValidString("aaa"));
    }

    @Test
    public void isValidString_shouldNotAllowSpaceAfterComma() {
        assertFalse(inputStringValidator.isValidString("10, 10"));
    }

    @Test
    public void isValidString_shouldNotAllowACharBeforeTheDigits() {
        assertFalse(inputStringValidator.isValidString("a10,10"));
    }
}