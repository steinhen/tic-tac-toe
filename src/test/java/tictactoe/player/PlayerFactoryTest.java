package tictactoe.player;

import org.junit.Assert;
import org.junit.Test;

public class PlayerFactoryTest {

    @Test
    public void getAllPlayersShouldReturn3Players() {
        Assert.assertEquals(
                3,
                new PlayerFactory().getAllPlayers().size()
        );
    }
}