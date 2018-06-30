package tictactoe;

import tictactoe.player.PlayerFactory;
import tictactoe.util.ConfigurationLoader;
import tictactoe.util.WinnerChecker;

import java.io.IOException;

public class TicTacToe {

    public static void main(String[] args) {

        try {
            ConfigurationLoader configurationLoader = new ConfigurationLoader();

            GameManager gameManager = new GameManager(
                    new Board(configurationLoader.getBoardSize()),
                    new PlayerFactory(configurationLoader).getAllPlayers(),
                    new WinnerChecker()
            );

            while (gameManager.play()) ;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
