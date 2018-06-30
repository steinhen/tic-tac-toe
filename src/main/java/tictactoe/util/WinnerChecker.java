package tictactoe.util;

import tictactoe.Board;

public class WinnerChecker {

    private Board board;

    public boolean findWinner(Board board) {
        this.board = board;
        return this.isAnyColumnClosed()
                || this.isAnyRowClosed()
                || this.isDiagonalAClosed()
                || this.isDiagonalBClosed();
    }

    private boolean isAnyRowClosed() {
        int maxIteration = this.board.getSize() - 1;
        for (int i = 0; i <= maxIteration; i++) {
            char baseValue = this.board.getCell(i, 0);
            for (int j = 0; j <= maxIteration; j++) {
                Character checkedValue = this.board.getCell(i, j);
                if (checkedValue == ' ' || checkedValue != baseValue) break;
                if (j == maxIteration) return logWinner();
            }
        }
        return false;
    }

    private boolean isAnyColumnClosed() {
        int maxIteration = this.board.getSize() - 1;
        for (int i = 0; i <= maxIteration; i++) {
            char baseValue = this.board.getCell(0, i);
            for (int j = 0; j <= maxIteration; j++) {
                Character checkedValue = this.board.getCell(j, i);
                if (checkedValue == ' ' || checkedValue != baseValue) break;
                if (j == maxIteration) return logWinner();
            }
        }
        return false;
    }

    private boolean logWinner() {
        System.out.println("Win!");
        return true;
    }

    private boolean isDiagonalAClosed() {
        int maxIteration = this.board.getSize() - 1;
        char baseValue = this.board.getCell(0, 0);
        for (int i = 0; i <= maxIteration; i++) {
            Character checkedValue = this.board.getCell(i, i);
            if (checkedValue == ' ' || checkedValue != baseValue) break;
            if (i == maxIteration) return logWinner();
        }
        return false;
    }

    private boolean isDiagonalBClosed() {
        int maxIteration = this.board.getSize() - 1;
        char baseValue = this.board.getCell(0, maxIteration);
        for (int i = 0; i <= maxIteration; i++) {
            Character checkedValue = this.board.getCell(i, maxIteration - i);
            if (checkedValue == ' ' || checkedValue != baseValue) break;
            if (i == maxIteration) return logWinner();
        }
        return false;
    }
}
