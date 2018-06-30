package tictactoe.reader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tictactoe.Board;
import tictactoe.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class PlayerPositionReaderTest {

    private static final String VALID_STRING = "0,0";

    @Mock
    private InputValidator inputStringValidator;

    @Mock
    private BufferedReader bufferedReader;

    @Test
    public void getPosition_shouldReturnValidValue() throws Exception {
        Mockito.when(bufferedReader.readLine()).thenReturn(VALID_STRING);
        Mockito.when(inputStringValidator.isValidString(VALID_STRING)).thenReturn(true);

        PlayerPositionReader positionInputReader = new PlayerPositionReader(bufferedReader, inputStringValidator);
        assertArrayEquals(new int[]{0, 0}, positionInputReader.getPosition(new Board()));
    }

    @Test(expected = RuntimeException.class)
    public void getPosition_ThrowsIOException() throws Exception {
        Mockito.when(bufferedReader.readLine()).thenThrow(IOException.class);

        PlayerPositionReader positionInputReader = new PlayerPositionReader(bufferedReader, inputStringValidator);
        positionInputReader.getPosition(new Board());
    }

}