import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MatchRepo implements Repo{
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
                            m1.setMatchKey(information);
                            break;
                        case 1:
                            m1.setGameWeek(Integer.parseInt(information));
                            break;
                        case 2:
                            m1.setHomePlayersId(readArrayFromFile(information));
                            break;
                    }
                    count++;
                    information = "";
                }
                else if (Line.charAt(i) == ';') {
                    m1.setAwayPlayersId(readArrayFromFile(information));
                    matchMap.put(m1.getMatchKey(),m1);
                    information="";
                }
                else {
                    information += Line.charAt(i);
                }
            }
        }
        /* for (Map.Entry<String, Match> me : matchMap.entrySet()) {
            Match m3;
            m3=me.getValue();
            System.out.println(m3.getMatchKey()+" "+m3.getGameWeek()+" "+m3.getHomePlayersId()+" "+m3.getAwayPlayersId());
        }*/
    }
    @Override
    public void writeToFile(String path) throws FileNotFoundException {
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
