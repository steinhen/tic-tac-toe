package tictactoe.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tictactoe.reader.ComputerPositionReader;
import tictactoe.reader.PlayerPositionReader;
import tictactoe.util.ConfigurationLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PlayerFactory {

    private static final String PLAYER_1 = "Player 1";
    private static final String PLAYER_2 = "Player 2";
    private static final String COMPUTER = "Computer";

    @Autowired
    private ComputerPositionReader computerPositionReader;

    @Autowired
    private PlayerPositionReader playerPositionReader;

    private ConfigurationLoader configurationLoader;

    @Autowired
    PlayerFactory(ConfigurationLoader configurationLoader) {
        this.configurationLoader = configurationLoader;
    }

    public List<Player> getAllPlayers() {

        List<Player> players = Arrays.asList(
                new Player(
                        COMPUTER,
                        configurationLoader.getComputerCharacter(),
                        computerPositionReader
                ),
                new Player(
                        PLAYER_1,
                        configurationLoader.getPlayer1Character(),
                        playerPositionReader
                ),
                new Player(
                        PLAYER_2,
                        configurationLoader.getPlayer2Character(),
                        playerPositionReader
                )
        );

        Collections.shuffle(players);

        return players;
    }
}
