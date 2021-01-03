import java.util.ArrayList;

public class EventManager {
    private int gameWeekID;
    private MatchRepo matchRepo;

    public void substitute(int playerId,int playerId2,int minute,String match) //+1 minute<60 ,  +2 minute>=60
    {

    }
    public void scoreGoal(int playerId,String match) // +6 for GK & DF , +5 for MF , +4 for FD
    {

    }
    public void assistGoal(int playerId,String match) // +3 for any player
    {

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
    public void saveShot(int playerId,String match) // +1 every 3 shots for GK
    {

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

    public void missPenalty(int playerId,String match) // -2 for any player
    {

    }
    public void receiveCard(String color, int playerId, String match) //-1 yellow   -3 Red  for any player
    {

    }
    public void scoreOwnGoal(int playerId, String match) // -2 for any player
    {

    }
}
