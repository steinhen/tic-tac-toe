package tictactoe.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tictactoe.Board;

/**
 * This class has the implementation of the rules for finding the game winner. It has the original rules: row, column,
 * or any of the diagonals filled with same character makes a winner.
 */
@Component
@Profile("defaultRules")
public class WinnerChecker {

    private Board board;

    /**
     * Checks if one of the rules to find a winner is matched. Either one of these:
     * 1) One of the columns has the same character in all of its positions
     * 2) One of the rows has the same character in all of its positions
     * 3) Diagonal A (from top left corner to bottom right corner) has the same character in all positions
     * 4) Diagonal B (from bottom left corner to top right corner) has the same character in all positions
     *
     * @param board board to be checked on a winner.
     * @return True if a winner was found based on the rules. False in case there is no winner found.
     */
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
                if (checkedValue == ' ' || checkedValue != baseValue) {
                    break;
                }
                if (j == maxIteration) {
                    return true;
                }
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
                if (checkedValue == ' ' || checkedValue != baseValue) {
                    break;
                }
                if (j == maxIteration) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDiagonalAClosed() {
        int maxIteration = this.board.getSize() - 1;
        char baseValue = this.board.getCell(0, 0);
        for (int i = 0; i <= maxIteration; i++) {
            Character checkedValue = this.board.getCell(i, i);
            if (checkedValue == ' ' || checkedValue != baseValue) {
                break;
            }
            if (i == maxIteration) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalBClosed() {
        int maxIteration = this.board.getSize() - 1;
        char baseValue = this.board.getCell(0, maxIteration);
        for (int i = 0; i <= maxIteration; i++) {
            Character checkedValue = this.board.getCell(i, maxIteration - i);
            if (checkedValue == ' ' || checkedValue != baseValue) {
                break;
            }
            if (i == maxIteration) {
                return true;
            }
        }
        return false;
    }
}
