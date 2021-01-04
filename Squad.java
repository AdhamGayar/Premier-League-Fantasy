import java.util.ArrayList;

public class Squad {

    private int squadID = 0 ; // #1
    private String squadName; // #2
    private int squadScore; // #3
    private int squadValue = 0; // #4
    private int numOfPlayers = 0; // #5
    private int squadCaptainID; // #6
    private int squadViceCaptainID; // #7
    private int currentNoGK = 0; // #8
    private int currentNoDF = 0; // #9
    private int currentNoMF = 0; // #10
    private int currentNoFD = 0; // #11
    private ArrayList<Integer> listOfPlayerID = new ArrayList<Integer>();// #12
    private ArrayList<Integer> mainSquad = new ArrayList<>(); // #13


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
    public int getSquadViceCaptainID() {
        return squadViceCaptainID;
    }

    public void setSquadViceCaptainID(int squadViceCaptainID) {
        this.squadViceCaptainID = squadViceCaptainID;
    }

    public int getSquadScore() {
        return squadScore;
    }

    public void setSquadScore(int squadScore) {
        this.squadScore = squadScore;
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
