import java.util.ArrayList;

public class EventManager {

    public void startMatch(String match)
    {
        int gameWeek = MatchRepo.matchMap.get(match).getGameWeek()-1;
        ArrayList<Integer> homePlayers= new ArrayList<>(MatchRepo.matchMap.get(match).getHomePlayersId());
        ArrayList<Integer> awayPlayers= new ArrayList<>(MatchRepo.matchMap.get(match).getAwayPlayersId());
        for (int i = 0; i < homePlayers.size(); i++) {
            PlayerRepo.playersMap.get(homePlayers.get(i)).addPlayerGameWeekPoints(gameWeek,1);
        }
        for (int i = 0; i < awayPlayers.size(); i++) {
            PlayerRepo.playersMap.get(awayPlayers.get(i)).addPlayerGameWeekPoints(gameWeek, 1);
        }
    }
    public void endMatch(String match)
    {
        int gameWeek = MatchRepo.matchMap.get(match).getGameWeek()-1;
        ArrayList<Integer> homePlayers= new ArrayList<>(MatchRepo.matchMap.get(match).getHomePlayersId());
        ArrayList<Integer> awayPlayers= new ArrayList<>(MatchRepo.matchMap.get(match).getAwayPlayersId());
        for (int i = 0; i < homePlayers.size(); i++) {
            PlayerRepo.playersMap.get(homePlayers.get(i)).addPlayerGameWeekPoints(gameWeek,1);
        }
        for (int i = 0; i < awayPlayers.size(); i++) {
            PlayerRepo.playersMap.get(awayPlayers.get(i)).addPlayerGameWeekPoints(gameWeek, 1);
        }
    }
    public void substitute(int playerIdOut,int playerIdIn,int minute,String team,String match) //+1 minute>=60
    {
        int gameWeek = MatchRepo.matchMap.get(match).getGameWeek()-1;
        if(minute>=60) {
            PlayerRepo.playersMap.get(playerIdOut).addPlayerGameWeekPoints(gameWeek, 1);
        }
        if (team.compareToIgnoreCase("home")==0)
        {
            int index =  MatchRepo.matchMap.get(match).getHomePlayersId().indexOf(playerIdOut);
            MatchRepo.matchMap.get(match).getHomePlayersId().set(index, playerIdIn);
        }
        else if (team.compareToIgnoreCase("away")==0){
            int index = MatchRepo.matchMap.get(match).getAwayPlayersId().indexOf(playerIdOut);
            MatchRepo.matchMap.get(match).getAwayPlayersId().set(index, playerIdIn);
        }
    }
    public void scoreGoal(int playerId,String match) // +6 for GK & DF , +5 for MF , +4 for FD
    {
        int gameWeek = MatchRepo.matchMap.get(match).getGameWeek()-1;
        String position = PlayerRepo.playersMap.get(playerId).getPlayerPosition();
        if (position.compareToIgnoreCase("GK")==0 || position.compareTo("DF")==0)
        {
            PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,6);
        }
        else if (position.compareToIgnoreCase("MF")==0)
        {
            PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,5);
        }
        else if (position.compareToIgnoreCase("FD")==0)
        {
            PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,4);
        }
    }
    public void assistGoal(int playerId,String match) // +3 for any player
    {
        int GW;
        GW= MatchRepo.matchMap.get(match).getGameWeek()-1;
        PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW,3);
    }
    public void saveShot(int playerId,String match,String team) // +1 every 3 shots for GK
    {
        int GW,currentCount;
        Match current;
        GW= MatchRepo.matchMap.get(match).getGameWeek()-1;
        current= MatchRepo.matchMap.get(match);

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
        int gameWeek = MatchRepo.matchMap.get(match).getGameWeek()-1;
        PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,-2);
    }
    public void receiveCard(String color, int playerId, String match,String team) //-1 yellow   -3 Red for any player
    {
        int GW;
        GW= MatchRepo.matchMap.get(match).getGameWeek()-1;

        if (color.compareToIgnoreCase("yellow") == 0)
        {
            PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW,-1);
        }
        if (color.compareToIgnoreCase("red") == 0) {
            PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW, -3);
            if (team.compareToIgnoreCase("home") == 0) {
                int index = MatchRepo.matchMap.get(match).getHomePlayersId().indexOf(playerId);
                MatchRepo.matchMap.get(match).getHomePlayersId().remove(index);
            }
            if (team.compareToIgnoreCase("away") == 0) {
                int index = MatchRepo.matchMap.get(match).getAwayPlayersId().indexOf(playerId);
                MatchRepo.matchMap.get(match).getAwayPlayersId().remove(index);
            }
        }
    }
    public void scoreOwnGoal(int playerId, String match) // -2 for any player
    {
        int gameWeek = MatchRepo.matchMap.get(match).getGameWeek()-1;
        PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,-2);
    }
    public void cleanSheet(String team,String match) // +4 for GK & DF , +1 for MF
    {
        int gameWeek= MatchRepo.matchMap.get(match).getGameWeek()-1;
        if(team.compareToIgnoreCase("Away")==0)
        {
            ArrayList<Integer> arr= MatchRepo.matchMap.get(match).getAwayPlayersId();
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
            ArrayList<Integer> arr= MatchRepo.matchMap.get(match).getHomePlayersId();
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
        int gameWeek= MatchRepo.matchMap.get(match).getGameWeek()-1;
        PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(gameWeek,5);
    }
    public void concedeGoal(String team,String match) //-1 every 2 goals for GK & DF
    {
        int gameWeek= MatchRepo.matchMap.get(match).getGameWeek()-1;
        if(team.compareToIgnoreCase("Away")==0)
        {
            if(MatchRepo.matchMap.get(match).getAwayConcededGoals()>=2)
            {
                ArrayList<Integer> arr= MatchRepo.matchMap.get(match).getAwayPlayersId();
                for(int i=0;i<arr.size();i++)
                {
                    String position=PlayerRepo.playersMap.get(arr.get(i)).getPlayerPosition();
                    if(position.compareToIgnoreCase("GK")==0 || position.compareToIgnoreCase("DF")==0)
                        PlayerRepo.playersMap.get(arr.get(i)).addPlayerGameWeekPoints(gameWeek,-1);
                    MatchRepo.matchMap.get(match).setAwayConcededGoals(0);
                }
            }
        }
        if(team.compareToIgnoreCase("Home")==0)
        {
            if(MatchRepo.matchMap.get(match).getHomeConcededGoals()>=2)
            {
                ArrayList<Integer> arr= MatchRepo.matchMap.get(match).getHomePlayersId();
                for(int i=0;i<arr.size();i++)
                {
                    String position=PlayerRepo.playersMap.get(arr.get(i)).getPlayerPosition();
                    if(position.compareToIgnoreCase("GK")==0 || position.compareToIgnoreCase("DF")==0)
                        PlayerRepo.playersMap.get(arr.get(i)).addPlayerGameWeekPoints(gameWeek,-1);
                    MatchRepo.matchMap.get(match).setHomeConcededGoals(0);
                }
            }
        }
    }
}