package tictactoe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tictactoe.exception.UnableToReadPositionException;
import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;
import tictactoe.util.WinnerChecker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameManagerTest {

    private static final char DOUBLE_PLAYER_CHAR = 'S';

    private List<Player> players = Collections.singletonList(new PlayerDouble());

    @Mock
    private Player mockedPlayer;

    @Mock
    private PlayerFactory playerFactory;

    @Mock
    private Board board;

    @Mock
    private WinnerChecker winnerChecker;

    @Test
    public void play_shouldReturnTrue_whenThereIsStillAPlayToBeDone() {
        when(playerFactory.getAllPlayers()).thenReturn(players);
        when(winnerChecker.findWinner(board)).thenReturn(false);
        when(board.isBoardFull()).thenReturn(false);

        GameManager gameManager = new GameManager(board, playerFactory, winnerChecker);
        assertTrue(gameManager.play());
    }

    @Test
    public void play_shouldReturnFalse_whenBoardIsFull() {
        when(playerFactory.getAllPlayers()).thenReturn(players);
        when(board.isBoardFull()).thenReturn(true);

        GameManager gameManager = new GameManager(board, playerFactory, winnerChecker);
        assertFalse(gameManager.play());
    }

    @Test
    public void play_shouldReturnFalse_whenThereIsAWinner() {
        when(playerFactory.getAllPlayers()).thenReturn(players);
        when(winnerChecker.findWinner(board)).thenReturn(true);

        GameManager gameManager = new GameManager(board, playerFactory, winnerChecker);
        assertFalse(gameManager.play());

    }

    @Test
    public void play_shouldReturnTrue_whenExceptionIsCaught() {
        when(playerFactory.getAllPlayers()).thenReturn(players);

        GameManager gameManager = new GameManager(board, playerFactory, winnerChecker);
        doThrow(RuntimeException.class).when(board).mark(0, 0, DOUBLE_PLAYER_CHAR);

        assertTrue(gameManager.play());
    }

    @Test
    public void play_shouldChangePlayer_afterSuccessfulPlay() {
        when(playerFactory.getAllPlayers()).thenReturn(players);
        when(winnerChecker.findWinner(board)).thenReturn(false);
        when(board.isBoardFull()).thenReturn(false);

        GameManager gameManager = new GameManager(board, playerFactory, winnerChecker);

        String previousPlayer = gameManager.getCurrentPlayer().getName();
        gameManager.play();

        assertNotEquals(previousPlayer, gameManager.getCurrentPlayer().getCharacter());
    }

    @Test
    public void play_shouldChangePlayer_afterFailPlay() {
        when(playerFactory.getAllPlayers()).thenReturn(players);

        GameManager gameManager = new GameManager(board, playerFactory, winnerChecker);

        doThrow(RuntimeException.class).when(board).mark(0, 0, DOUBLE_PLAYER_CHAR);

        String previousPlayer = gameManager.getCurrentPlayer().getName();
        gameManager.play();

        assertEquals(previousPlayer, gameManager.getCurrentPlayer().getName());

    }

    @Test
    public void play_shouldReturnFalse_whenExceptionIsCaught() throws Exception {
        when(playerFactory.getAllPlayers()).thenReturn(Arrays.asList(mockedPlayer));

        GameManager gameManager = new GameManager(board, playerFactory, winnerChecker);

        doThrow(UnableToReadPositionException.class).when(mockedPlayer).getPosition(board);

        assertFalse(gameManager.play());

    }

    class PlayerDouble extends Player {

        PlayerDouble() {
            super("Stub", DOUBLE_PLAYER_CHAR, null);
        }

        @Override
        public int[] getPosition(Board board) {
            return new int[]{0, 0};
        }
    }

}