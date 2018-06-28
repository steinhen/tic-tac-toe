import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TicTacToe {

    public static void main(String[] args) {

        GameManager gameManager = new GameManager(
                new Board(),
                new DefaultPositionReader(
                        new BufferedReader(new InputStreamReader(System.in)),
                        new InputValidator()
                ),
                new WinnerChecker()
        );

        while (gameManager.play()) ;

    }

}
