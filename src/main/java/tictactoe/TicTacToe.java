package tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Tic Tac Toe game that runs in the command line. This is a enhanced version of the original game, having an extra
 * player and a configurable board size. Game runs while there is still a play to be done.
 */
@SpringBootApplication
public class TicTacToe implements CommandLineRunner {

    @Autowired
    private GameManager gameManager;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TicTacToe.class);
        springApplication.setBannerMode(Banner.Mode.OFF);

        springApplication.run(args);
    }

    @Override
    public void run(String... args) {
        while (gameManager.play()) ;
    }
}
