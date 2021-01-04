import java.util.ArrayList;

public class Squad {
    private ArrayList<Integer> listOfPlayerID = new ArrayList<Integer>();// #10
    private int numOfPlayers = 0; // #4
    private String squadName; // #2
    private int squadValue = 0; // #3
    private int squadID = 0 ; // #1
    private int squadCaptainID; // #5
    private int currentNoGK = 0; // #6
    private int currentNoDF = 0; // #7
    private int currentNoMF = 0; // #8
    private int currentNoFD = 0; // #9
    private ArrayList<Integer> mainSquad = new ArrayList<Integer>(); // #11

    public ArrayList<Integer> getMainSquad() {
        return mainSquad;
    }

    public void setMainSquad(ArrayList<Integer> mainSquad) {
        this.mainSquad = mainSquad;
    }

    public Squad() {
    }
    public String getSquadName() {
        return squadName;
    }
    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }
    public int getSquadValue() {
        return squadValue;
    }

    public int getCurrentNoGK()
    { return currentNoGK; }

    public void setCurrentNoGK(int currentNoGK) {
        this.currentNoGK = currentNoGK;
    }

    public int getCurrentNoDF() {
        return currentNoDF;
    }

    public void setCurrentNoDF(int currentNoDF) {
        this.currentNoDF = currentNoDF;
    }

    public int getCurrentNoMF() {
        return currentNoMF;
    }

    public void setCurrentNoMF(int currentNoMF) {
        this.currentNoMF = currentNoMF;
    }

    public int getCurrentNoFD() {
        return currentNoFD;
    }

    public void setCurrentNoFD(int currentNoFD) {
        this.currentNoFD = currentNoFD;
    }

    public ArrayList getListOfPlayerID() {
        return listOfPlayerID;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public int getSquadID() {
        return squadID;
    }

    public void setSquadID(int squadID) {
        this.squadID = squadID;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void setSquadValue(int squadValue) {
        this.squadValue = squadValue;
    }

    public int getSquadCaptainID() {
        return squadCaptainID;
    }

    public void setSquadCaptainID(int squadCaptainID) {
        this.squadCaptainID = squadCaptainID;
    }

    public void setListOfPlayerID(ArrayList<Integer> listOfPlayerID) {
        this.listOfPlayerID = listOfPlayerID;
    }
    public void addToListOfPlayerID(int playerID)
    {
        listOfPlayerID.add(playerID);
    }
    public void addToMainSquad(int playerID)
    {
        mainSquad.add(playerID);
    }
}
