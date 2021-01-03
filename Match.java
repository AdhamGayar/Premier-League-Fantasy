import java.util.ArrayList;

public class Match {
    private String matchKey; // #1
    private ArrayList<Integer> homePlayersId = new ArrayList<>(11);  //#3
    private ArrayList<Integer> awayPlayersId = new ArrayList<>(11);  //#4
    private int gameWeek; // 01 #2
    private int homeShotsCounter;
    private int awayShotsCounter;
    private int homeConcededGoals;
    private int awayConcededGoals;

    public int getHomeShotsCounter() {
        return homeShotsCounter;
    }

    public void setHomeShotsCounter(int homeShotsCounter) {
        this.homeShotsCounter = homeShotsCounter;
    }

    public int getAwayShotsCounter() {
        return awayShotsCounter;
    }

    public void setAwayShotsCounter(int awayShotsCounter) {
        this.awayShotsCounter = awayShotsCounter;
    }

    public int getHomeConcededGoals() {
        return homeConcededGoals;
    }

    public void setHomeConcededGoals(int homeConcededGoals) {
        this.homeConcededGoals = homeConcededGoals;
    }

    public int getAwayConcededGoals() {
        return awayConcededGoals;
    }

    public void setAwayConcededGoals(int awayConcededGoals) {
        this.awayConcededGoals = awayConcededGoals;
    }

    public String getMatchKey() {
        return matchKey;
    }

    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    public ArrayList<Integer> getHomePlayersId() {
        return homePlayersId;
    }

    public void setHomePlayersId(ArrayList<Integer> homePlayersId) {
        this.homePlayersId = homePlayersId;
    }

    public ArrayList<Integer> getAwayPlayersId() {
        return awayPlayersId;
    }

    public void setAwayPlayersId(ArrayList<Integer> awayPlayersId) {
        this.awayPlayersId = awayPlayersId;
    }

    public int getGameWeek() {
        return gameWeek;
    }

    public void setGameWeek(int gameWeek) {
        this.gameWeek = gameWeek;
    }
}
