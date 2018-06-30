package tictactoe.reader;

import org.junit.Test;
import tictactoe.Board;

import static org.junit.Assert.assertEquals;

public class ComputerPositionReaderTest {

    @Test
    public void getPosition_shouldReturnArrayWith2Ints() {
        ComputerPositionReader computerPositionReader = new ComputerPositionReader();
        assertEquals(2, computerPositionReader.getPosition(new Board()).length);
    }
}