import java.util.ArrayList;

public class UserService {
    private UserRepo userRepo;
    private SquadRepo squadRepo;
    private PlayerRepo playerRepo;
    Squad s = new Squad(); //new
    void createSquad(String username,String squadName) // NEW
    {
        s.setSquadName(squadName);
        s.setSquadID(SquadRepo.squadMap.size()+1);
        userRepo.usersMap.get(username).setSquadID(s.getSquadID());
        SquadRepo.squadMap.put(s.getSquadID(),s);
    }
    void addPlayerToSquad(int playerId) // NEW
    {
        //playerRepo.playersMap.get(playerId);
        ArrayList<Integer> myPlayers= new ArrayList<>(15) ;
        myPlayers.add(playerId);
        s.setListOfPlayerID(myPlayers);
    }
    boolean removePlayerFromSquad(String username,int playerId)
    {
        return true;
    }
    void setCaptain(int playerID)
    {

    }
    void getSquadNames(String username)
    {

    }
}
