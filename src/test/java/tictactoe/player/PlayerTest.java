package tictactoe.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tictactoe.Board;
import tictactoe.reader.PlayerPositionReader;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    private static final Character CHAR = 'C';
    private static final String NAME = "Name";

    @Mock
    private PlayerPositionReader positionInputReader;

    @Test
    public void getPosition() throws Exception {
        Board board = new Board(3);
        int[] position = {0, 0};
        Mockito.when(positionInputReader.getPosition(board)).thenReturn(position);
        Player player = new Player(NAME, CHAR, positionInputReader);
        assertArrayEquals(position, player.getPosition(board));
    }

    @Test
    public void getName() {
        Player player = new Player(NAME, CHAR, null);
        assertEquals(NAME, player.getName());
    }

    @Test
    public void getCharacter() {
        Player player = new Player(NAME, CHAR, null);
        assertEquals(CHAR, player.getCharacter());
    }
}