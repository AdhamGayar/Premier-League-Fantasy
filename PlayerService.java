public class PlayerService {
   private PlayerRepo playerRepo;
    void changePrice(double price,int playerId){

    }
    void changePoints(int points,int playerId){

    }
    boolean editPlayer(Player player){
        return true;
    }
    void addNewPlayer(Player player)
    {

        /*String playerName;
        String playerPosition;
         int playerValue;
         int playerID;
         String playerTeam;*/
        PlayerRepo.playersMap.put(player.getPlayerID(),player);
    }
}
