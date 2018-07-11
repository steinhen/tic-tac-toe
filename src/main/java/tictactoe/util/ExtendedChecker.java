package tictactoe.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tictactoe.Board;

@Component
@Profile("extendedRules")
public class ExtendedChecker extends WinnerChecker {

    @Override
    public boolean findWinner(Board board) {
        return super.findWinner(board) || areCornersTaken(board);
    }

    private boolean areCornersTaken(Board board) {
        int maxSize = board.getSize() - 1;

        Character baseChar = board.getCell(0, 0);

        return baseChar != ' ' &&
                board.getCell(maxSize, maxSize) == baseChar &&
                board.getCell(0, maxSize) == baseChar &&
                board.getCell(maxSize, 0) == baseChar;
    }

}
