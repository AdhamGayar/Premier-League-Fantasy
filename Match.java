import java.util.ArrayList;

public class Match {
    private String homeTeam;
    private String awayTeam;
    private ArrayList<Integer> homePlayersId = new ArrayList<>(11);
    private ArrayList<Integer> awayPlayersId = new ArrayList<>(11);
    private String gameWeekMatch; // 0101

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
}
