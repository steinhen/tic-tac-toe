import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class GameManagerTest {

    @Mock
    private Board board;

    @Mock
    private WinnerChecker winnerChecker;

    @Mock
    private DefaultPositionReader positionInputReader;

    @Test
    public void play_shouldReturnTrue_whenThereIsStillAPlayToBeDone() {

        Mockito.when(positionInputReader.getPositions()).thenReturn(new String[]{"0", "0"});
        Mockito.when(winnerChecker.findWinner(board)).thenReturn(false);
        Mockito.when(board.isBoardFull()).thenReturn(false);

        GameManager gameManager = new GameManager(board, positionInputReader, winnerChecker);
        assertTrue(gameManager.play());

    }

    @Test
    public void play_shouldReturnFalse_whenBoardIsFull() {

        Mockito.when(positionInputReader.getPositions()).thenReturn(new String[]{"0", "0"});
        Mockito.when(board.isBoardFull()).thenReturn(true);

        GameManager gameManager = new GameManager(board, positionInputReader, winnerChecker);
        assertFalse(gameManager.play());

    }

    @Test
    public void play_shouldReturnFalse_whenThereIsAWinner() {

        Mockito.when(positionInputReader.getPositions()).thenReturn(new String[]{"0", "0"});
        Mockito.when(winnerChecker.findWinner(board)).thenReturn(true);

        GameManager gameManager = new GameManager(board, positionInputReader, winnerChecker);
        assertFalse(gameManager.play());

    }

    @Test
    public void play_shouldReturnTrue_whenExceptionIsCaught() {

        Mockito.when(positionInputReader.getPositions()).thenReturn(new String[]{"0", "0"});
        Mockito.doThrow(RuntimeException.class).when(board).mark(0, 0, 'X');

        GameManager gameManager = new GameManager(board, positionInputReader, winnerChecker);
        assertTrue(gameManager.play());

    }

    @Test
    public void play_shouldChangePlayer_afterSuccessfulPlay() {

        Mockito.when(positionInputReader.getPositions()).thenReturn(new String[]{"0", "0"});
        Mockito.when(winnerChecker.findWinner(board)).thenReturn(false);
        Mockito.when(board.isBoardFull()).thenReturn(false);

        GameManager gameManager = new GameManager(board, positionInputReader, winnerChecker);

        String previousPlayer = gameManager.getPlayer();
        gameManager.play();

        assertNotEquals(previousPlayer, gameManager.getPlayer());

    }

    @Test
    public void play_shouldChangePlayer_afterFailPlay() {

        Mockito.when(positionInputReader.getPositions()).thenReturn(new String[]{"0", "0"});
        Mockito.doThrow(RuntimeException.class).when(board).mark(0, 0, 'X');

        GameManager gameManager = new GameManager(board, positionInputReader, winnerChecker);

        String previousPlayer = gameManager.getPlayer();
        gameManager.play();

        assertEquals(previousPlayer, gameManager.getPlayer());

    }

}