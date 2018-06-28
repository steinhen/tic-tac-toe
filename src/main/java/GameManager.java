import java.util.Arrays;
import java.util.List;

class GameManager {

    private static final String PLAYER_TURN_MESSAGE = "Player %s, you're up. Enter a position like x,y:";

    private static final String ENTER_ANOTHER_POSITION_MESSAGE = " Enter another one.";

    private Board board;
    private WinnerChecker winnerChecker;
    private DefaultPositionReader positionInputReader;
    private List<Character> players = Arrays.asList('X', 'O');
    private int turn = 0;

    GameManager(Board board, DefaultPositionReader positionInputReader, WinnerChecker winnerChecker) {
        this.board = board;
        this.winnerChecker = winnerChecker;
        this.positionInputReader = positionInputReader;
    }

    boolean play() {
        System.out.println(String.format(PLAYER_TURN_MESSAGE, this.getPlayer()));

        try {
            String[] split = positionInputReader.getPositions();
            this.board.mark(
                    Integer.valueOf(split[0]),
                    Integer.valueOf(split[1]),
                    players.get(this.getPlayerId())
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

    String getPlayer() {
        return String.valueOf(getPlayerId() + 1);
    }

    private int getPlayerId() {
        return this.turn % players.size();
    }

    private boolean hasPlayYetToBeDone() {
        return !winnerChecker.findWinner(this.board) && !board.isBoardFull();
    }

    private void makeNextPlayerTurn() {
        this.turn++;
    }
}
