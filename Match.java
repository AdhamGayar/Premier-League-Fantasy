import java.util.ArrayList;

public class Match {
    private String homeTeam; //#2
    private String awayTeam; // #3
    private ArrayList<Integer> homePlayersId = new ArrayList<>(11);  //#4
    private ArrayList<Integer> awayPlayersId = new ArrayList<>(11);  //#5
    private String gameWeekMatch; // 0101 #1

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
    public String getGameWeekMatch() {
        return gameWeekMatch;
    }

    public void setGameWeekMatch(String gameWeekMatch) {
        this.gameWeekMatch = gameWeekMatch;
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
}
