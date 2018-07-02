package tictactoe.player;

import tictactoe.Board;
import tictactoe.exception.UnableToReadPositionException;
import tictactoe.reader.PositionReader;

/**
 * Abstraction of the player of the game.
 */
public class Player {

    private Character character;
    private String name;
    private PositionReader positionInputReader;

    /**
     * Construct the player with its name, character and the reader for its plays.
     *
     * @param name                name of the player.
     * @param character           character to be placed in the board.
     * @param positionInputReader where to read the players play from.
     */
    protected Player(String name, Character character, PositionReader positionInputReader) {
        this.name = name;
        this.character = character;
        this.positionInputReader = positionInputReader;
    }

    /**
     * Gets the x and y indexes indicating the position for the player's play.
     *
     * @param board board.
     * @return Array of int, where X is in index 0 and Y in index 1.
     * @throws UnableToReadPositionException when not able to read the position.
     */
    public int[] getPosition(final Board board) throws UnableToReadPositionException {
        return this.positionInputReader.getPosition(board);
    }

    public Character getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player=[");
        sb.append("character=[").append(character).append(']');
        sb.append(", name=[").append(name).append(']');
        sb.append(", positionInputReader=[").append(positionInputReader).append(']');
        sb.append(']');
        return sb.toString();
    }
}
