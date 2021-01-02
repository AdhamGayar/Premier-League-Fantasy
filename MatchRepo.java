import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MatchRepo {
    public static Map< String, Match> matchMap = new HashMap<String, Match>();

    public void readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String Line = "";
        String information = "";
        while (sc.hasNextLine()) {
            Line = sc.nextLine();
            int count = 0;
            Match m1 = new Match();
            for (int i = 0; i < Line.length(); i++) {
                if (Line.charAt(i) == '~') {
                    switch (count) {
                        case 0:
                            m1.setGameWeekMatch(information);
                            break;
                        case 1:
                            m1.setHomeTeam(information);
                            break;
                        case 2:
                            m1.setAwayTeam(information);
                            break;
                        case 3:
                            m1.setHomePlayersId(readArrayFromFile(information));
                            break;
                    }
                    count++;
                    information = "";
                }
                else if (Line.charAt(i) == ';') {
                    m1.setAwayPlayersId(readArrayFromFile(information));
                    matchMap.put(m1.getGameWeekMatch(),m1);
                    information="";
                }
                else {
                    information += Line.charAt(i);
                }
            }
        }
        /*for (Map.Entry<Integer, Squad> me : squadMap.entrySet()) {
            Squad s3;
            s3 = me.getValue();
            System.out.println(s3.getSquadID() + " " + s3.getSquadName() + " " + s3.getSquadValue() + " " + s3.getNumOfPlayers() + " " + s3.getSquadCaptainID() + " " + s3.getCurrentNoGK() + " " + s3.getCurrentNoDF() + " " + s3.getCurrentNoMF() + " " + s3.getCurrentNoFD()+ " " + s3.getListOfPlayerID());
        }*/
    }

    public ArrayList<Integer> readArrayFromFile(String information) {
        int size = information.length();
        String element = "";
        ArrayList<Integer> listOfPlayerID = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (information.charAt(i) == '[')
                continue;
            else if (information.charAt(i) == ',') {
                listOfPlayerID.add(Integer.parseInt(element));
                element = "";
            } else if (information.charAt(i) == ']') {
                listOfPlayerID.add(Integer.parseInt(element));
            } else {
                element += information.charAt(i);
            }
        }
        return listOfPlayerID;
    }
}
