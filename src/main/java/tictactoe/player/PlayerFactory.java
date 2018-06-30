package tictactoe.player;

import tictactoe.reader.ComputerPositionReader;
import tictactoe.reader.PlayerPositionReader;
import tictactoe.util.ConfigurationLoader;
import tictactoe.util.InputValidator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerFactory {

    private static final String PLAYER_1 = "Player 1";
    private static final String PLAYER_2 = "Player 2";
    private static final String COMPUTER = "Computer";

    private ConfigurationLoader configurationLoader;

    public PlayerFactory(ConfigurationLoader configurationLoader) {
        this.configurationLoader = configurationLoader;
    }

    public List<Player> getAllPlayers() {

        List<Player> players = Arrays.asList(
                new Player(
                        COMPUTER,
                        configurationLoader.getComputerCharacter(),
                        new ComputerPositionReader()),
                new Player(
                        PLAYER_1,
                        configurationLoader.getPlayer1Character(),
                        new PlayerPositionReader(
                                new BufferedReader(new InputStreamReader(System.in)),
                                new InputValidator()
                        )
                ),
                new Player(
                        PLAYER_2,
                        configurationLoader.getPlayer2Character(),
                        new PlayerPositionReader(
                                new BufferedReader(new InputStreamReader(System.in)),
                                new InputValidator()
                        )
                )
        );

        Collections.shuffle(players);

        return players;
    }
}
