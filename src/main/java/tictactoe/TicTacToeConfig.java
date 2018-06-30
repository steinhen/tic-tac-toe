package tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tictactoe.player.PlayerFactory;
import tictactoe.reader.PlayerPositionReader;
import tictactoe.util.ConfigurationLoader;
import tictactoe.util.InputValidator;
import tictactoe.util.WinnerChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class TicTacToeConfig {

    @Autowired
    private ConfigurationLoader configurationLoader;

    @Autowired
    private WinnerChecker winnerChecker;

    @Autowired
    private PlayerFactory playerFactory;

    @Bean
    GameManager gameManager() {
        return new GameManager(
                board(),
                playerFactory.getAllPlayers(),
                winnerChecker
        );
    }

    @Bean
    Board board() {
        return new Board(configurationLoader.getBoardSize());
    }

    @Bean
    PlayerPositionReader playerPositionReader() {
        return new PlayerPositionReader(
                new BufferedReader(new InputStreamReader(System.in)),
                new InputValidator()
        );
    }
}
