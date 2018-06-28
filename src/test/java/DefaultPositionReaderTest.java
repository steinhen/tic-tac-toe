import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class DefaultPositionReaderTest {

    @Mock
    private InputValidator inputStringValidator;

    @Mock
    private BufferedReader bufferedReader;

    @Test
    public void getPosition_shouldReturnValidValue() throws Exception {

        String validString = "0,0";
        Mockito.when(bufferedReader.readLine()).thenReturn(validString);
        Mockito.when(inputStringValidator.isValidString(validString)).thenReturn(true);

        DefaultPositionReader positionInputReader = new DefaultPositionReader(bufferedReader, inputStringValidator);
        String[] positions = {"0", "0"};
        Assert.assertArrayEquals(positions, positionInputReader.getPositions());

    }

    @Test
    public void getPosition_handlesExceptionWhenReadingInput() throws Exception {

        Mockito.when(bufferedReader.readLine()).thenThrow(IOException.class);
        Mockito.when(inputStringValidator.isValidString("")).thenReturn(true);

        DefaultPositionReader positionInputReader = new DefaultPositionReader(bufferedReader, inputStringValidator);
        String[] positions = {""};
        Assert.assertArrayEquals(positions, positionInputReader.getPositions());

    }

}