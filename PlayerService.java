import java.util.Scanner;

public class PlayerService {
    void changePrice(double price,int playerId){

    }
    void changePoints(int points,int playerId){

    }
    boolean editPlayer(Player player){
        return true;
    }
    void addNewPlayer()
    {
        Player player = new Player();
        Scanner input = new Scanner(System.in);
        Scanner intinput = new Scanner(System.in);
        String s;
        int value;
        System.out.println("Please enter player name ");
        s = input.nextLine();
        player.setPlayerName(s);
        System.out.println("Please enter player team");
        s = input.nextLine();
        player.setPlayerTeam(s);
        System.out.println("Please enter player position");
        s = input.nextLine();
        player.setPlayerPosition(s);
        System.out.println("Please enter player value");
        value = intinput.nextInt();
        player.setPlayerValue(value);
        player.setPlayerID(PlayerRepo.playersMap.size());
        PlayerRepo.playersMap.put(player.getPlayerID(),player);
    }
}
