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
    boolean addPlayerToSquad(String username , Integer playerId) // NEW
    {
        int squadID = userRepo.usersMap.get(username).getSquadID();
        int numOfPlayers = SquadRepo.squadMap.get(squadID).getNumOfPlayers();
        if(!budgetChecker(username,playerId)) return false;
        if(!PlayerIdentityChecker(username,playerId)) return false;
        if(!playersCounterChecker(username,playerId)) return false;
        if(!playersPositionChecker(username,playerId)) return false;

        SquadRepo.squadMap.get(squadID).setPlayerID(playerId);
        SquadRepo.squadMap.get(squadID).setNumOfPlayers(++numOfPlayers);
        return true;
    }
    boolean budgetChecker(String username , Integer playerId)
    {
        int squadID = userRepo.usersMap.get(username).getSquadID();
        int playerValue = playerRepo.playersMap.get(playerId).getPlayerValue();
        int sum = SquadRepo.squadMap.get(squadID).getSquadValue();
        sum = sum + playerValue;
        if(sum>100)
        {
            System.out.println("budget exceeded");
            return false;
        }
        squadRepo.squadMap.get(squadID).setSquadValue(sum);
    return true;
    }
    boolean PlayerIdentityChecker(String username , Integer playerId)
    {
        int squadID = userRepo.usersMap.get(username).getSquadID();
        int arraySize = squadRepo.squadMap.get(squadID).getListOfPlayerID().size();
        for(int i=0; i < arraySize;i++) {
            if (playerId == squadRepo.squadMap.get(squadID).getListOfPlayerID().get(i))
                return false;
        }
        return true;
    }
    boolean playersPositionChecker(String username , int playerId)
    {
        int squadID = userRepo.usersMap.get(username).getSquadID();
        int GK = SquadRepo.squadMap.get(squadID).getCurrentNoGK();
        int DF = SquadRepo.squadMap.get(squadID).getCurrentNoDF();
        int MF = SquadRepo.squadMap.get(squadID).getCurrentNoMF();
        int FD = SquadRepo.squadMap.get(squadID).getCurrentNoFD();
        String position = playerRepo.playersMap.get(playerId).getPlayerPosition();
        String playerName = playerRepo.playersMap.get(playerId).getPlayerName();
        if(position.equals("GK"))
        {
            if(GK<2)
            {
                SquadRepo.squadMap.get(squadID).setCurrentNoGK(++GK);
                System.out.println("added "+playerName + " position " + position );
                System.out.println( (2 - GK) + " GK left");
            } else return false;
        }
        else if(position.equals("DF"))
        {
            if(DF<5) {
                SquadRepo.squadMap.get(squadID).setCurrentNoDF(++DF);
                System.out.println("added "+playerName + " position " + position );
                System.out.println( (5 - DF) + " DF left");
            } else return false;
        }
        else if(position.equals("MF")){

            if(MF<5) {
                SquadRepo.squadMap.get(squadID).setCurrentNoMF(++MF);
                System.out.println("added "+playerName + " position " + position );
                System.out.println( (5 - MF) + " MF left");
            } else return false;
        }
        else if(position.equals("FD"))
        {
            if(FD<3){
                SquadRepo.squadMap.get(squadID).setCurrentNoFD(++FD);
                System.out.println("added "+playerName + " position " + position );
                System.out.println( (3 - FD) + " FD left");
            } else return false;
        }
        return true;
    }
    boolean playersCounterChecker(String username , int playerId)
    {
        int squadID = userRepo.usersMap.get(username).getSquadID();
        String playerTeam = playerRepo.playersMap.get(playerId).getPlayerTeam();
        int arraySize = squadRepo.squadMap.get(squadID).getListOfPlayerID().size();
        int counter = 0;
        for(int i=0; i < arraySize;i++) {
            if (playerTeam.compareTo(playerRepo.playersMap.get(squadRepo.squadMap.get(squadID).getListOfPlayerID().get(i)).getPlayerTeam())==0)
            {
                counter++;
            }
        }
        if(counter>=3)
        {
            return false;
        }
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
