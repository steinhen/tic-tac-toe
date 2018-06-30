package tictactoe.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {

    private static final String PROPERTIES_FILE_NAME = "config.properties";
    private final Properties properties;

    public ConfigurationLoader() throws IOException {
        this.properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
        if (inputStream != null) {
            this.properties.load(inputStream);
        } else {
            throw new FileNotFoundException("Configuration file [" + PROPERTIES_FILE_NAME + "] not found.");
        }
        inputStream.close();
    }

    public Character getPlayer1Character() {
        return properties.getProperty("player1Character").charAt(0);
    }

    public Character getPlayer2Character() {
        return properties.getProperty("player2Character").charAt(0);
    }

    Character getComputerCharacter() {
        return properties.getProperty("computerCharacter").charAt(0);
    }

    public int getBoardSize() {
        return Integer.parseInt(properties.getProperty("boardSize"));
    }

}
