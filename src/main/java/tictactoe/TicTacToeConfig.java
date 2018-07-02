package tictactoe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tictactoe.reader.PlayerPositionReader;
import tictactoe.util.InputValidator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class TicTacToeConfig {

    @Bean
    PlayerPositionReader playerPositionReader() {
        return new PlayerPositionReader(
                new BufferedReader(new InputStreamReader(System.in)),
                new InputValidator()
        );
    }
}
