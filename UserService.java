import java.util.ArrayList;
public class UserService {

    void createSquad(String username, String squadName) {
        Squad squad = new Squad();
        squad.setSquadName(squadName);
        squad.setSquadID(SquadRepo.squadMap.size() + 1);
        UserRepo.usersMap.get(username).setSquadID(squad.getSquadID());
        SquadRepo.squadMap.put(squad.getSquadID(), squad);
    }

    boolean addPlayerToSquad(String username, Integer playerId) {
        int squadID = UserRepo.usersMap.get(username).getSquadID();
        int numOfPlayers = SquadRepo.squadMap.get(squadID).getNumOfPlayers();
        if (!budgetChecker(username, playerId)) return false;
        if (!PlayerIdentityChecker(username, playerId)) return false;
        if (!playersCounterChecker(username, playerId)) return false;
        if (!playersPositionChecker(username, playerId)) return false;

        SquadRepo.squadMap.get(squadID).addToListOfPlayerID(playerId);
        SquadRepo.squadMap.get(squadID).setNumOfPlayers(++numOfPlayers);
        return true;
    }

    private boolean budgetChecker(String username, Integer playerId) {
        int squadID = UserRepo.usersMap.get(username).getSquadID();
        int playerValue = PlayerRepo.playersMap.get(playerId).getPlayerValue();
        int sum = SquadRepo.squadMap.get(squadID).getSquadValue();
        int userBudget = UserRepo.usersMap.get(username).getUserBudget();
        sum = sum + playerValue;
        if (sum > 100) {
            System.out.println("budget exceeded");
            return false;
        }
        SquadRepo.squadMap.get(squadID).setSquadValue(sum);
        UserRepo.usersMap.get(username).setUserBudget(userBudget - playerValue);
        return true;
    }

    private boolean PlayerIdentityChecker(String username, Integer playerId) {
        int squadID = UserRepo.usersMap.get(username).getSquadID();
        int arraySize = SquadRepo.squadMap.get(squadID).getListOfPlayerID().size();
        for (int i = 0; i < arraySize; i++) {
            if (playerId == SquadRepo.squadMap.get(squadID).getListOfPlayerID().get(i))
                return false;
        }
        return true;
    }

    private boolean playersPositionChecker(String username, int playerId) {
        int squadID = UserRepo.usersMap.get(username).getSquadID();
        int GK = SquadRepo.squadMap.get(squadID).getCurrentNoGK();
        int DF = SquadRepo.squadMap.get(squadID).getCurrentNoDF();
        int MF = SquadRepo.squadMap.get(squadID).getCurrentNoMF();
        int FD = SquadRepo.squadMap.get(squadID).getCurrentNoFD();
        String position = PlayerRepo.playersMap.get(playerId).getPlayerPosition();
        String playerName = PlayerRepo.playersMap.get(playerId).getPlayerName();
        if (position.compareToIgnoreCase("GK") == 0) {
            if (GK < 2) {
                SquadRepo.squadMap.get(squadID).setCurrentNoGK(++GK);
                System.out.println("added " + playerName + " position " + position);
                System.out.println((2 - GK) + " GK left");
            } else return false;
        } else if (position.compareToIgnoreCase("DF") == 0) {
            if (DF < 5) {
                SquadRepo.squadMap.get(squadID).setCurrentNoDF(++DF);
                System.out.println("added " + playerName + " position " + position);
                System.out.println((5 - DF) + " DF left");
            } else return false;
        } else if (position.compareToIgnoreCase("MF") == 0) {

            if (MF < 5) {
                SquadRepo.squadMap.get(squadID).setCurrentNoMF(++MF);
                System.out.println("added " + playerName + " position " + position);
                System.out.println((5 - MF) + " MF left");
            } else return false;
        } else if (position.compareToIgnoreCase("FD") == 0) {
            if (FD < 3) {
                SquadRepo.squadMap.get(squadID).setCurrentNoFD(++FD);
                System.out.println("added " + playerName + " position " + position);
                System.out.println((3 - FD) + " FD left");
            } else return false;
        }
        return true;
    }

    private boolean playersCounterChecker(String username, int playerId) {
        int squadID = UserRepo.usersMap.get(username).getSquadID();
        String playerTeam = PlayerRepo.playersMap.get(playerId).getPlayerTeam();
        int arraySize = SquadRepo.squadMap.get(squadID).getListOfPlayerID().size();
        ArrayList<Integer> listOfPlayers = new ArrayList<>(SquadRepo.squadMap.get(squadID).getListOfPlayerID());
        int counter = 0;
        for (int i = 0; i < arraySize; i++) {
            if (playerTeam.compareTo(PlayerRepo.playersMap.get(listOfPlayers.get(i)).getPlayerTeam()) == 0) {
                counter++;
            }
        }
        return counter < 3;
    }

    void addPlayerToMainSquad(String username, Integer playerId) //constraints: at least 1 goalkeeper, 3 defenders and 1 forward
    {
        int squadID = UserRepo.usersMap.get(username).getSquadID();
        // SquadRepo.squadMap.get(squadID).addToMainSquad(playerId);
        SquadRepo.squadMap.get(squadID);
    }

    boolean replacePlayer(String username, int playerId) {
        return true;
    }

    public void setCaptain(String userName, int playerID) {
        int squadID = UserRepo.usersMap.get(userName).getSquadID();
        ArrayList<Integer> arr = SquadRepo.squadMap.get(squadID).getMainSquad();
        boolean inSquad = false;
        for (int i = 0; i < arr.size(); i++) {
            if (PlayerRepo.playersMap.get(arr.get(i)).getPlayerID() == playerID) {
                inSquad = true;
                break;
            }
        }
        if (inSquad)
            SquadRepo.squadMap.get(squadID).setSquadCaptainID(playerID);
    }

    public void calculateSquadScore(String username, int gameWeek) {
        int sum = 0;
        int squadID = UserRepo.usersMap.get(username).getSquadID();
        ArrayList<Integer> playersID = new ArrayList<>(SquadRepo.squadMap.get(squadID).getMainSquad());
        int captainID = SquadRepo.squadMap.get(squadID).getSquadCaptainID();
        for (int i = 0; i < playersID.size(); i++) {
            if (PlayerRepo.playersMap.get(playersID.get(i)).getPlayerID() == captainID) {
                sum = sum + (2 * PlayerRepo.playersMap.get(playersID.get(i)).getPlayerSeasonPoints().indexOf(gameWeek - 1));
            } else
                sum = sum + PlayerRepo.playersMap.get(playersID.get(i)).getPlayerSeasonPoints().indexOf(gameWeek - 1);
        }
        SquadRepo.squadMap.get(squadID).setSquadScore(sum);
    }

    public boolean printPlayers(String position) {
        if (position.compareToIgnoreCase("GK") == 0) {
            for (int i = 0; i < 71; i++) {
                Player p1 = PlayerRepo.playersMap.get(i);
                System.out.println(p1.getPlayerName() + "\t" + p1.getPlayerID() + "\t" + p1.getPlayerTeam() + "\t" + p1.getPlayerPosition() + "\t" + p1.getPlayerValue());
            }
        } else if (position.compareToIgnoreCase("DF") == 0) {
            for (int i = 71; i < 294; i++) {
                Player p1 = PlayerRepo.playersMap.get(i);
                System.out.println(p1.getPlayerName() + "\t" + p1.getPlayerID() + "\t" + p1.getPlayerTeam() + "\t" + p1.getPlayerPosition() + "\t" + p1.getPlayerValue());
            }
        } else if (position.compareToIgnoreCase("MF") == 0) {
            for (int i = 294; i < 540; i++) {
                Player p1 = PlayerRepo.playersMap.get(i);
                System.out.println(p1.getPlayerName() + "\t" + p1.getPlayerID() + "\t" + p1.getPlayerTeam() + "\t" + p1.getPlayerPosition() + "\t" + p1.getPlayerValue());
            }
        }
        else if (position.compareToIgnoreCase("FD") == 0) {
            for (int i = 541; i < 619; i++) {
                Player p1 = PlayerRepo.playersMap.get(i);
                System.out.println(p1.getPlayerName() + "\t" + p1.getPlayerID() + "\t" + p1.getPlayerTeam() + "\t" + p1.getPlayerPosition() + "\t" + p1.getPlayerValue());
            }
        }
        else
        {
            System.out.println("enter correct position");
            return false;
        }
        return true;
    }
}

/* SquadRepo squadRepo = new SquadRepo();
        String path= "Fantasy-Database\\Squad-History\\gameweek" + gameWeek + ".txt";
        try {
            Map<Integer, Squad> squadTempMap = new HashMap<>(squadRepo.read(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/