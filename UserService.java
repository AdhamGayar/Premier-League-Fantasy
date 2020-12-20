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
    void addPlayerToSquad(String username , int playerId) // NEW
    {
        int squadID = userRepo.usersMap.get(username).getSquadID();
        squadRepo.squadMap.get(squadID).setPlayerID(playerId);
    }
    boolean removePlayerFromSquad(String username , int playerId)
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
