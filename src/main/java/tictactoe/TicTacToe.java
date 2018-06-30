package tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
