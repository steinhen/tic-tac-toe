package tictactoe.player;

import tictactoe.Board;
import tictactoe.reader.PlayerPositionReader;

public class Player {

    private Character character;
    private String name;
    private PlayerPositionReader positionInputReader;

    protected Player(String name, Character character, PlayerPositionReader positionInputReader) {
        this.name = name;
        this.character = character;
        this.positionInputReader = positionInputReader;
    }

    public String[] getPosition(final Board board) {
        return this.positionInputReader.getPositions(board);
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
