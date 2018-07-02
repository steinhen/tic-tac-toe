package tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;
import tictactoe.util.WinnerChecker;

import java.util.List;

/**
 * Game manager is responsible for the dynamic of the game. It manages the interactions between the entities involved.
 * It handles the players (whose turn is up), the board and the rules of the game.
 */
@Service
class GameManager {

    private static final String PLAYER_TURN_MESSAGE = "%s, you're up. Enter a position like x,y:";
    private static final String ENTER_ANOTHER_POSITION_MESSAGE = " Enter another one.";
    private static final String FULL_BOARD_MESSAGE = "Board is full, there are no more plays to be done! GAME OVER!";
    private static final String WINNER_MESSAGE = "%s WINS!";

    private Board board;
    private WinnerChecker winnerChecker;

    private List<Player> players;
    private int turn = 0;

    @Autowired
    GameManager(Board board, PlayerFactory playerFactory, WinnerChecker winnerChecker) {
        this.board = board;
        this.winnerChecker = winnerChecker;
        this.players = playerFactory.getAllPlayers();
    }

    /**
     * This is the core method of the game. It orchestrates the plays, who's turn is up and controls whether there is
     * still a play to be done - essentially by checking for a winner or available places in the board.
     *
     * @return True in case there is still a play to be done. False, otherwise (in case some one is a winner or the
     * board is full)ó.
     */
    boolean play() {

        System.out.println(String.format(PLAYER_TURN_MESSAGE, this.getCurrentPlayer().getName()));

        try {

            int[] position = this.getCurrentPlayer().getPosition(this.board);
            this.board.mark(
                    position[0],
                    position[1],
                    this.getCurrentPlayer().getCharacter()
            );

        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + ENTER_ANOTHER_POSITION_MESSAGE);
            System.out.println(board);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        System.out.println(board);
        makeNextPlayerTurn();

        return hasPlayYetToBeDone();
    }

    Player getCurrentPlayer() {
        return players.get(getPlayerIndex());
    }

    private int getPlayerIndex() {
        return this.turn % players.size();
    }

    private boolean hasPlayYetToBeDone() {
        return !foundWinner() && !isBoardFull();
    }

    private boolean isBoardFull() {
        boolean boardFull = board.isBoardFull();
        if (boardFull) {
            System.out.println(FULL_BOARD_MESSAGE);
        }
        return boardFull;
    }

    private boolean foundWinner() {
        boolean winner = winnerChecker.findWinner(this.board);
        if (winner) {
            System.out.println(String.format(WINNER_MESSAGE, this.getCurrentPlayer().getName()));
        }
        return winner;
    }

    private void makeNextPlayerTurn() {
        this.turn++;
    }

}
