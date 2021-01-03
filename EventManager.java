
public class EventManager {
    private MatchRepo matchRepo;


    public void substitute(int playerId,int playerId2,int minute,String match) //+1 minute<60 ,  +2 minute>=60
    {

    }
    public void scoreGoal(int playerId,String match) // +6 for GK & DF , +5 for MF , +4 for FD
    {

    }
    public void assistGoal(int playerId,String match) // +3 for any player
    {
        int GW;
        GW=matchRepo.matchMap.get(match).getGameWeek();
        PlayerRepo.playersMap.get(playerId).addPlayerGameWeekPoints(GW,3);
    }
    public void cleanSheet(int playerId,String match) // +4 for GK & DF , +1 for MF
    {

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
    public void savePenalty(int playerId,String match) // +5 for any player
    {

    }
    public void concedeGoal(int playerId,String match) //-1 every 2 goals for GK & DF
    {

    }
    public void missPenalty(int playerId,String match) // -2 for any player
    {

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

    }
}
