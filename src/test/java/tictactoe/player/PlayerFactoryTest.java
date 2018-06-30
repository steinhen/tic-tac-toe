package tictactoe.player;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.util.ConfigurationLoader;

import java.io.IOException;

public class PlayerFactoryTest {

    @Test
    public void getAllPlayers() throws IOException {
        Assert.assertEquals(
                3,
                new PlayerFactory(new ConfigurationLoader()).getAllPlayers().size()
        );
    }
}