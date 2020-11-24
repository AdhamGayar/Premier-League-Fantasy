public class Player {
    private String playerName;
    private String playerPosition;
    private int playerValue;
    private int playerID;
    private int playerTotalPoints;
    private int playerMatchPoints;
    private String playerTeam;

    public Player()
    {

    }
    public Player(String playerName, String playerPosition, int playerValue) {
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.playerValue = playerValue;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerValue() {
        return playerValue;
    }

    public void setPlayerValue(int playerValue) {
        this.playerValue = playerValue;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayerTotalPoints() {
        return playerTotalPoints;
    }

    public void setPlayerTotalPoints(int playerTotalPoints) {
        this.playerTotalPoints = playerTotalPoints;
    }

    public int getPlayerMatchPoints() {
        return playerMatchPoints;
    }

    public void setPlayerMatchPoints(int playerMatchPoints) {
        this.playerMatchPoints = playerMatchPoints;
    }
    public String getPlayerTeam() { return playerTeam; }

    public void setPlayerTeam(String playerTeam) { this.playerTeam = playerTeam; }
}
