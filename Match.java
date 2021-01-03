import java.util.ArrayList;

public class Match {
    private String matchKey; // #1
    private ArrayList<Integer> homePlayersId = new ArrayList<>(11);  //#3
    private ArrayList<Integer> awayPlayersId = new ArrayList<>(11);  //#4
    private int gameWeek; // 01 #2

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
