package tictactoe.reader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tictactoe.Board;
import tictactoe.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class PlayerPositionReaderTest {

    @Mock
    private InputValidator inputStringValidator;

    @Mock
    private BufferedReader bufferedReader;

    @Test
    public void getPosition_shouldReturnValidValue() throws Exception {

        String validString = "0,0";
        Mockito.when(bufferedReader.readLine()).thenReturn(validString);
        Mockito.when(inputStringValidator.isValidString(validString)).thenReturn(true);

        PlayerPositionReader positionInputReader = new PlayerPositionReader(bufferedReader, inputStringValidator);
        String[] positions = {"0", "0"};
        Assert.assertArrayEquals(positions, positionInputReader.getPositions(new Board()));

    }

    @Test
    public void getPosition_handlesExceptionWhenReadingInput() throws Exception {

        Mockito.when(bufferedReader.readLine()).thenThrow(IOException.class);
        Mockito.when(inputStringValidator.isValidString("")).thenReturn(true);

        PlayerPositionReader positionInputReader = new PlayerPositionReader(bufferedReader, inputStringValidator);
        String[] positions = {""};
        Assert.assertArrayEquals(positions, positionInputReader.getPositions(new Board()));

    }

}