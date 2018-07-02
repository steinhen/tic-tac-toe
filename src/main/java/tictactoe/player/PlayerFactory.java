package tictactoe.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tictactoe.reader.ComputerPositionReader;
import tictactoe.reader.PlayerPositionReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Factory class to get the players for the TicTacToe game.
 */
@Service
public class PlayerFactory {

    private static final String PLAYER_1 = "Player 1";
    private static final String PLAYER_2 = "Player 2";
    private static final String COMPUTER = "Computer";

    @Autowired
    private ComputerPositionReader computerPositionReader;

    @Autowired
    private PlayerPositionReader playerPositionReader;

    @Value("${player1Character}")
    private Character player1Character;

    @Value("${player2Character}")
    private Character player2Character;

    @Value("${computerCharacter}")
    private Character computerCharacter;

    /**
     * Gets the shuffled list of all players.
     *
     * @return List of players.
     */
    public List<Player> getAllPlayers() {

        List<Player> players = Arrays.asList(
                new Player(
                        COMPUTER,
                        computerCharacter,
                        computerPositionReader
                ),
                new Player(
                        PLAYER_1,
                        player1Character,
                        playerPositionReader
                ),
                new Player(
                        PLAYER_2,
                        player2Character,
                        playerPositionReader
                )
        );

        Collections.shuffle(players);

        return players;
    }
}
