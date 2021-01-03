import java.util.ArrayList;
public class Player {
    private String playerName;
    private String playerPosition;
    private int playerValue;
    private int playerID;
    private int playerTotalPoints = 0;
    private ArrayList<Integer> playerSeasonPoints = new ArrayList<>(38);
    private String playerTeam;
    public Player()
    {}
    public Player(int playerID,String playerName, String playerPosition, int playerValue, String playerTeam) {
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.playerValue = playerValue;
        this.playerID = playerID;
        this.playerTeam = playerTeam;
    }

    public ArrayList<Integer> getPlayerSeasonPoints() {
        return playerSeasonPoints;
    }
    public void setPlayerSeasonPoints(ArrayList<Integer> playerSeasonPoints) {
        this.playerSeasonPoints = playerSeasonPoints;
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

    public String getPlayerTeam() { return playerTeam; }

    public void setPlayerTeam(String playerTeam) { this.playerTeam = playerTeam; }
    public void addPlayerGameWeekPoints(int index, int points)
    {
        int totalPoints = playerSeasonPoints.get(index) + points;
        playerSeasonPoints.add(index,totalPoints);
    }
    private int getPlayerGameWeekPoints(int index)
    {
        return playerSeasonPoints.get(index);
    }
}
