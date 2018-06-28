class WinnerChecker {

    private Board board;

    boolean findWinner(Board board) {
        this.board = board;
        return this.closeCol()
                || this.closeRow()
                || this.closeDiag1()
                || this.closeDiag2();
    }

    private boolean closeRow() {
        int colNum = this.board.getSize() - 1;
        for (int i = 0; i <= colNum; i++) {
            char baseValue = this.board.getCell(i, 0);
            for (int j = 0; j <= colNum; j++) {
                Character checkedValue = this.board.getCell(i, j);
                if (checkedValue == ' ' || checkedValue != baseValue) break;
                if (j == colNum) return logWinner();
            }
        }
        return false;
    }

    private boolean closeCol() {
        int rowNum = this.board.getSize() - 1;
        for (int i = 0; i <= rowNum; i++) {
            char baseValue = this.board.getCell(0, i);
            for (int j = 0; j <= rowNum; j++) {
                Character checkedValue = this.board.getCell(j, i);
                if (checkedValue == ' ' || checkedValue != baseValue) break;
                if (j == rowNum) return logWinner();
            }
        }
        return false;
    }

    private boolean logWinner() {
        System.out.println("Win!");
        return true;
    }

    private boolean closeDiag1() {
        int rowNum = this.board.getSize() - 1;
        char baseValue = this.board.getCell(0, 0);
        for (int i = 0; i <= rowNum; i++) {
            Character checkedValue = this.board.getCell(i, i);
            if (checkedValue == ' ' || checkedValue != baseValue) break;
            if (i == rowNum) return logWinner();
        }
        return false;
    }

    private boolean closeDiag2() {
        int count = this.board.getSize() - 1;
        char baseValue = this.board.getCell(0, count);
        for (int i = 0; i <= count; i++) {
            Character checkedValue = this.board.getCell(i, count - i);
            if (checkedValue == ' ' || checkedValue != baseValue) break;
            if (i == count) return logWinner();
        }
        return false;
    }
}
