package tictactoe;

import tictactoe.player.Player;
import tictactoe.util.WinnerChecker;

import java.util.List;

class GameManager {

    private static final String PLAYER_TURN_MESSAGE = "%s, you're up. Enter a position like x,y:";
    private static final String ENTER_ANOTHER_POSITION_MESSAGE = " Enter another one.";

    private Board board;
    private WinnerChecker winnerChecker;

    private List<Player> players;
    private int turn = 0;

    GameManager(Board board, List<Player> players, WinnerChecker winnerChecker) {
        this.board = board;
        this.winnerChecker = winnerChecker;
        this.players = players;
    }

    boolean play() {
        System.out.println(String.format(PLAYER_TURN_MESSAGE, this.getCurrentPlayer().getName()));

        try {

            String[] split = this.getCurrentPlayer().getPosition(this.board);
            this.board.mark(
                    Integer.valueOf(split[0]),
                    Integer.valueOf(split[1]),
                    this.getCurrentPlayer().getCharacter()
            );

        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + ENTER_ANOTHER_POSITION_MESSAGE);
            System.out.println(board);
            return true;
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
        return !winnerChecker.findWinner(this.board) && !board.isBoardFull();
    }

    private void makeNextPlayerTurn() {
        this.turn++;
    }

}
