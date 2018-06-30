package tictactoe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tictactoe.player.Player;
import tictactoe.util.WinnerChecker;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class GameManagerTest {

    private static final char STUB_PLAYER_CHAR = 'S';

    private List<Player> mockedPlayers = Collections.singletonList(new StubPlayer());

    @Mock
    private Board board;

    @Mock
    private WinnerChecker winnerChecker;

    @Test
    public void play_shouldReturnTrue_whenThereIsStillAPlayToBeDone() {
        Mockito.when(winnerChecker.findWinner(board)).thenReturn(false);
        Mockito.when(board.isBoardFull()).thenReturn(false);

        GameManager gameManager = new GameManager(board, mockedPlayers, winnerChecker);
        assertTrue(gameManager.play());

    }

    @Test
    public void play_shouldReturnFalse_whenBoardIsFull() {

        Mockito.when(board.isBoardFull()).thenReturn(true);

        GameManager gameManager = new GameManager(board, mockedPlayers, winnerChecker);
        assertFalse(gameManager.play());

    }

    @Test
    public void play_shouldReturnFalse_whenThereIsAWinner() {
        Mockito.when(winnerChecker.findWinner(board)).thenReturn(true);

        GameManager gameManager = new GameManager(board, mockedPlayers, winnerChecker);
        assertFalse(gameManager.play());

    }

    @Test
    public void play_shouldReturnTrue_whenExceptionIsCaught() {

        GameManager gameManager = new GameManager(board, mockedPlayers, winnerChecker);

        Mockito.doThrow(RuntimeException.class).when(board).mark(0, 0, STUB_PLAYER_CHAR);

        assertTrue(gameManager.play());

    }

    @Test
    public void play_shouldChangePlayer_afterSuccessfulPlay() {

        Mockito.when(winnerChecker.findWinner(board)).thenReturn(false);
        Mockito.when(board.isBoardFull()).thenReturn(false);

        GameManager gameManager = new GameManager(board, mockedPlayers, winnerChecker);

        String previousPlayer = gameManager.getCurrentPlayer().getName();
        gameManager.play();

        assertNotEquals(previousPlayer, gameManager.getCurrentPlayer().getCharacter());

    }

    @Test
    public void play_shouldChangePlayer_afterFailPlay() {

        GameManager gameManager = new GameManager(board, mockedPlayers, winnerChecker);

        Mockito.doThrow(RuntimeException.class).when(board).mark(0, 0, STUB_PLAYER_CHAR);

        String previousPlayer = gameManager.getCurrentPlayer().getName();
        gameManager.play();

        assertEquals(previousPlayer, gameManager.getCurrentPlayer().getName());

    }

    class StubPlayer extends Player {

        StubPlayer() {
            super("Stub", STUB_PLAYER_CHAR, null);
        }

        @Override
        public String[] getPosition(Board board) {
            return new String[]{"0", "0"};
        }
    }

}