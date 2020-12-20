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
    boolean addPlayerToSquad(String username , int playerId) // NEW
    {

        int squadID = userRepo.usersMap.get(username).getSquadID();
        //Squad squad = SquadRepo.squadMap.get(squadID);
        int GK = s.getCurrentNoGK();
        int DF = s.getCurrentNoDF();
        int MF = s.getCurrentNoMF();
        int FD = s.getCurrentNoFD();
        String position = playerRepo.playersMap.get(playerId).getPlayerPosition();
        if(position.equals("DF"))
        {
            if(DF<5) {
                System.out.println(DF);
                DF++;
                System.out.println(DF);
                SquadRepo.squadMap.get(squadID).setCurrentNoGK(DF);
                System.out.println(DF);
            }
            else {return false;}
        }
        else if(position.equals("GK"))
        {
            if(GK<2)
            {
                SquadRepo.squadMap.get(squadID).setCurrentNoGK(++GK);
                System.out.println(GK);
            }
        else
        {
            return false;
        }
        }
        else if(position.equals("MF")){

            if(MF<5) {
                SquadRepo.squadMap.get(squadID).setCurrentNoGK(++MF);
        System.out.println(MF); }
        else return false;
        }
        else if(position.equals("FD"))
        {
            if(FD<3){
                SquadRepo.squadMap.get(squadID).setCurrentNoGK(++FD);
                System.out.println(FD);
            } else return false;
        }

        squadRepo.squadMap.get(squadID).setPlayerID(playerId);
        return true;
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
