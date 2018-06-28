public class Board {

    private static final int MIN_BOARD_SIZE = 3;
    private static final int MAX_BOARD_SIZE = 10;
    private static final String CANNOT_MARK_THIS_POSITION_MESSAGE = "Cannot mark this position.";
    private static final String INVALID_POSITION_MESSAGE = "Invalid Position.";
    private static final String INVALID_BOARD_SIZE_MESSAGE = "Invalid board size";
    private Character[][] board;

    Board() {
        this(3);
    }

    Board(int size) {
        validateBoardSize(size);
        this.board = new Character[size][size];
        init();
    }

    private void validateBoardSize(int size) {
        if (MIN_BOARD_SIZE > size || size > MAX_BOARD_SIZE) {
            throw new RuntimeException(INVALID_BOARD_SIZE_MESSAGE);
        }
    }

    private void init() {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    int getSize() {
        return this.board.length;
    }

    Character getCell(int x, int y) {
        return this.board[x][y];
    }

    void mark(int x, int y, char c) {
        isInTheBoard(x);
        isInTheBoard(y);
        isPositionEmpty(x, y);
        board[x][y] = c;
    }

    private void isPositionEmpty(int x, int y) {
        if (board[x][y] != ' ') {
            throw new RuntimeException(CANNOT_MARK_THIS_POSITION_MESSAGE);
        }
    }

    private void isInTheBoard(int position) {
        if (position < 0 || position >= board.length) {
            throw new RuntimeException(INVALID_POSITION_MESSAGE);
        }
    }

    boolean isBoardFull() {
        for (Character[] aBoard : this.board) {
            for (int j = 0; j < this.board.length; j++) {
                if (aBoard[j] == ' ') return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Board:\n");
        for (Character[] characters : board) {
            sb.append('|');
            for (Character character : characters) {
                sb.append(String.valueOf(character)).append('|');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}