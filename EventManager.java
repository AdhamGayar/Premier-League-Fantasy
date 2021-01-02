import java.util.ArrayList;

public class EventManager {
    private ArrayList<Integer> listofPlayersID = new ArrayList<>(22);
    private int gameWeekID;

    public void substitute(int playerId,int playerId2,int minute) //+1 minute<60 ,  +2 minute>=60
    {

    }
    public void scoreGoal(int playerId) // +6 for GK & DF , +5 for MF , +4 for FD
    {

    }
    public void assistGoal(int playerId) // +3 for any player
    {

    }
    public void cleansheet(int playerId) // +4 for GK & DF , +1 for MF
    {

    }
    public void saveShot(int playerId) // +1 every 3 shots for GK
    {

    }
    public void savePenalty(int playerId) // +5 for any player
    {

    }
    public void concedeGoal(int playerId) //-1 every 2 goals for GK & DF
    {

    }
    public void missPenalty(int playerId) // -2 for any player
    {

    }
    public void recieveCard(int playerId, String color) //-1 yellow   -3 Red  for any player
    {

    }
    public void scoreOwnGoal(int playerId) // -2 for any player
    {

    }
}
