import java.util.ArrayList;

public class EventManager {
    private MatchRepo matchRepo;
    private PlayerRepo playerRepo;

    public void startMatch(String match)
    {
        int gameWeek = matchRepo.matchMap.get(match).getGameWeek();
        ArrayList<Integer> homePlayers= new ArrayList<>(matchRepo.matchMap.get(match).getHomePlayersId());
        ArrayList<Integer> awayPlayers= new ArrayList<>(matchRepo.matchMap.get(match).getAwayPlayersId());
        for (int i = 0; i < homePlayers.size(); i++) {
            playerRepo.playersMap.get(homePlayers.get(i)).addPlayerGameWeekPoints(gameWeek,1);
        }
        for (int i = 0; i < awayPlayers.size(); i++) {
            playerRepo.playersMap.get(awayPlayers.get(i)).addPlayerGameWeekPoints(gameWeek, 1);
        }
    }
    public void endMatch(String match)
    {
        int gameWeek = matchRepo.matchMap.get(match).getGameWeek();
        ArrayList<Integer> homePlayers= new ArrayList<>(matchRepo.matchMap.get(match).getHomePlayersId());
        ArrayList<Integer> awayPlayers= new ArrayList<>(matchRepo.matchMap.get(match).getAwayPlayersId());
        for (int i = 0; i < homePlayers.size(); i++) {
            playerRepo.playersMap.get(homePlayers.get(i)).addPlayerGameWeekPoints(gameWeek,1);
        }
        for (int i = 0; i < awayPlayers.size(); i++) {
            playerRepo.playersMap.get(awayPlayers.get(i)).addPlayerGameWeekPoints(gameWeek, 1);
        }
    }
    public void substitute(int playerIdOut,int playerIdIn,int minute,String team,String match) //+1 minute>=60
    {
        int gameWeek = matchRepo.matchMap.get(match).getGameWeek();
        if(minute>=60) {
            playerRepo.playersMap.get(playerIdOut).addPlayerGameWeekPoints(gameWeek, 1);
        }
        if (team.compareToIgnoreCase("home")==0)
        {
            matchRepo.matchMap.get(match).getHomePlayersId().remove(playerIdOut);
            matchRepo.matchMap.get(match).getHomePlayersId().add(playerIdIn);
        }
        else if (team.compareToIgnoreCase("away")==0){
            matchRepo.matchMap.get(match).getAwayPlayersId().remove(playerIdOut);
            matchRepo.matchMap.get(match).getAwayPlayersId().add(playerIdIn);
        }
    }
    public void scoreGoal(int playerId,String match) // +6 for GK & DF , +5 for MF , +4 for FD
    {
        int gameWeek = matchRepo.matchMap.get(match).getGameWeek();
        String position = playerRepo.playersMap.get(playerId).getPlayerPosition();
        if (position.compareToIgnoreCase("GK")==0 || position.compareTo("DF")==0)
        {
            playerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,6);
        }
        else if (position.compareToIgnoreCase("MF")==0)
        {
            playerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,5);
        }
        else if (position.compareToIgnoreCase("FD")==0)
        {
            playerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,4);
        }
    }
    public void assistGoal(int playerId,String match) // +3 for any player
    {
        int GW;
        GW=matchRepo.matchMap.get(match).getGameWeek();
        PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW,3);
    }
    public void saveShot(int playerId,String match,String team) // +1 every 3 shots for GK
    {
        int GW,currentCount;
        Match current;
        GW=matchRepo.matchMap.get(match).getGameWeek();
        current=matchRepo.matchMap.get(match);

        if (team.compareToIgnoreCase("home")==0)
        {
            currentCount=current.getHomeShotsCounter();
            current.setHomeShotsCounter(currentCount+1);
            if (current.getHomeShotsCounter()==3)
            {
                PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW,1);
                current.setHomeShotsCounter(0);
            }

        }
        if (team.compareToIgnoreCase("away")==0)
        {
            currentCount=current.getAwayShotsCounter();
            current.setAwayShotsCounter(currentCount+1);
            if (current.getAwayShotsCounter()==3)
            {
                PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW,1);
                current.setAwayConcededGoals(0);
            }
        }
    }
    public void missPenalty(int playerId,String match) // -2 for any player
    {
        int gameWeek = matchRepo.matchMap.get(match).getGameWeek();
        playerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,-2);

    }
    public void receiveCard(String color, int playerId, String match,String team) //-1 yellow   -3 Red for any player
    {
        int GW;
        GW=matchRepo.matchMap.get(match).getGameWeek();

        if (color.compareToIgnoreCase("yellow") == 0)
        {
            PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW,-1);
        }
        if (color.compareToIgnoreCase("red") == 0) {
            PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW, -3);
            if (team.compareToIgnoreCase("home") == 0) {
                matchRepo.matchMap.get(match).getHomePlayersId().remove(playerId);
            }
            if (team.compareToIgnoreCase("away") == 0) {
                matchRepo.matchMap.get(match).getAwayPlayersId().remove(playerId);
            }
        }
    }
    public void scoreOwnGoal(int playerId, String match) // -2 for any player
    {
        int gameWeek = matchRepo.matchMap.get(match).getGameWeek();
        playerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,-2);
    }
    public void cleanSheet(String team,String match) // +4 for GK & DF , +1 for MF
    {
        if(team.compareToIgnoreCase("Away")==0)
        {
            int gameWeek=matchRepo.matchMap.get(match).getGameWeek();
            ArrayList<Integer> arr=matchRepo.matchMap.get(match).getAwayPlayersId();
            for (int i=0;i<arr.size();i++)
            {
                String position=PlayerRepo.playersMap.get(arr.get(i)).getPlayerPosition();
                if(position.compareToIgnoreCase("GK") == 0 || position.compareToIgnoreCase("DF") == 0)
                {
                    PlayerRepo.playersMap.get(arr.get(i)).addPlayerGameWeekPoints(gameWeek,4);
                }
                else if(position.compareToIgnoreCase("MF") == 0 )
                {
                    PlayerRepo.playersMap.get(arr.get(i)).addPlayerGameWeekPoints(gameWeek,1);
                }
            }
        }
        else
        {
            int gameWeek=matchRepo.matchMap.get(match).getGameWeek();
            ArrayList<Integer> arr=matchRepo.matchMap.get(match).getHomePlayersId();
            for (int i=0;i<arr.size();i++)
            {
                String position=PlayerRepo.playersMap.get(arr.get(i)).getPlayerPosition();
                if(position.compareToIgnoreCase("GK") == 0 || position.compareToIgnoreCase("DF") == 0)
                {
                    PlayerRepo.playersMap.get(arr.get(i)).addPlayerGameWeekPoints(gameWeek,4);
                }
                else if(position.compareToIgnoreCase("MF") == 0 )
                {
                    PlayerRepo.playersMap.get(arr.get(i)).addPlayerGameWeekPoints(gameWeek,1);
                }
            }
        }
    }
    public void savePenalty(int playerId,String match) // +5 for any player
    {
        int gameWeek=matchRepo.matchMap.get(match).getGameWeek();
        PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,5);
    }
    public void concedeGoal(int playerId,String team,String match) //-1 every 2 goals for GK & DF
    {
        int gameWeek=matchRepo.matchMap.get(match).getGameWeek();
        if(team.compareToIgnoreCase("Away")==0)
        {
            if(matchRepo.matchMap.get(match).getAwayConcededGoals()>=2)
            {
                ArrayList<Integer> arr=matchRepo.matchMap.get(match).getAwayPlayersId();
                for(int i=0;i<arr.size();i++)
                {
                    String position=PlayerRepo.playersMap.get(arr.get(i)).getPlayerPosition();
                    if(position.compareToIgnoreCase("GK")==0 || position.compareToIgnoreCase("DF")==0)
                        PlayerRepo.playersMap.get(arr.get(i)).addPlayerGameWeekPoints(gameWeek,-1);
                    matchRepo.matchMap.get(match).setAwayConcededGoals(0);
                }
            }
        }
        if(team.compareToIgnoreCase("Home")==0)
        {
            if(matchRepo.matchMap.get(match).getHomeConcededGoals()>=2)
            {
                ArrayList<Integer> arr=matchRepo.matchMap.get(match).getHomePlayersId();
                for(int i=0;i<arr.size();i++)
                {
                    String position=PlayerRepo.playersMap.get(arr.get(i)).getPlayerPosition();
                    if(position.compareToIgnoreCase("GK")==0 || position.compareToIgnoreCase("DF")==0)
                        PlayerRepo.playersMap.get(arr.get(i)).addPlayerGameWeekPoints(gameWeek,-1);
                    matchRepo.matchMap.get(match).setHomeConcededGoals(0);
                }
            }
        }
    }
}