package inf112.fiasko.roborally.networking.containers;

import inf112.fiasko.roborally.objects.Player;

import java.util.List;

/**
 * This class contains information about the game board to be used and the game's players
 */
public class GameStartInfo {
    private String boardName;
    private List<Player> playerList;
    private String playerName;

    /**
     * Empty initialization method required by kryo
     */
    public GameStartInfo() {
    }

    /**
     * Instantiates a new GameStartInfo object
     *
     * @param boardName  The name of the board to be used, with extension
     * @param playerList List of players for the game
     */
    public GameStartInfo(String boardName, List<Player> playerList, String name) {
        this.playerName = name;
        this.boardName = boardName;
        this.playerList = playerList;
    }

    /**
     * Gets the player name of the current player
     *
     * @return The player name of the current player
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the player name of the current player
     *
     * @param playerName The player name of the current player
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Gets the list of players
     *
     * @return A list of players
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Sets the list of players for the game
     *
     * @param playerList List of players for the game
     */
    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    /**
     * Gets the board name
     *
     * @return The board name
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * Sets the name of the board to be used
     *
     * @param boardName The name of the board to be used, with extension
     */
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

}
