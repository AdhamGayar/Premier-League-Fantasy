
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
    public void cleanSheet(int playerId,String match) // +4 for GK & DF , +1 for MF
    {

    }
    public void saveShot(int playerId,String match) // +1 every 3 shots for GK
    {

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
    public void receiveCard(String color, int playerId, String match) //-1 yellow   -3 Red  for any player
    {

    }
    public void scoreOwnGoal(int playerId, String match) // -2 for any player
    {

    }
}
