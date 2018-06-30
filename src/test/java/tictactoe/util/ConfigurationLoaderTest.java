package tictactoe.util;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ConfigurationLoaderTest {

    @Test
    public void getPlayer1Character() throws IOException {
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        assertNotNull(configurationLoader.getPlayer1Character());
    }

    @Test
    public void getPlayer2Character() throws IOException {
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        assertNotNull(configurationLoader.getPlayer2Character());
    }

    @Test
    public void getComputerCharacter() throws IOException {
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        assertNotNull(configurationLoader.getComputerCharacter());
    }

    @Test
    public void getBoardSize() throws IOException {
        try {
            ConfigurationLoader configurationLoader = new ConfigurationLoader();
            configurationLoader.getBoardSize();
        } catch (NumberFormatException e) {
            fail();
        }
    }

}