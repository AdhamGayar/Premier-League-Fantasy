import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayerRepo implements Repo{
    public static Map<Integer,Player> playersMap = new HashMap<Integer,Player>();

    public void readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String Line="";
        String information="";
        while (sc.hasNextLine())
        {
            Line=sc.nextLine();
            int count=0;
            Player p1 = new Player();
            for(int i=0;i<Line.length();i++) {
                if (Line.charAt(i) == '~') {
                    switch (count) {
                        case 0:p1.setPlayerID(Integer.parseInt(information));break;
                        case 1:p1.setPlayerName(information);break;
                        case 2:p1.setPlayerTeam(information);break;
                        case 3:p1.setPlayerPosition(information);break;
                        case 4:p1.setPlayerValue(Integer.parseInt(information));break;
                        case 5:p1.setPlayerSeasonPoints(readArrayFromFile(information));break;
                    }
                    count++;
                    information="";
                }
                else if(Line.charAt(i)==';')
                {
                    p1.setPlayerTotalPoints(Integer.parseInt(information));
                    playersMap.put(p1.getPlayerID(),p1);
                    information="";
                }
                else
                {
                    information+=Line.charAt(i);
                }
            }
        }
       /* for (Map.Entry<Integer, Player> me : playersMap.entrySet()) {
            Player p3;
            p3=me.getValue();
            System.out.println(p3.getPlayerID()+" "+p3.getPlayerName()+" "+p3.getPlayerTeam()+" "+p3.getPlayerPosition()+" "+p3.getPlayerValue()+" "+p3.getPlayerGameWeekPoints()+" "+p3.getPlayerTotalPoints());
        }*/
    }
    public void writeToFile(String path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(path));
        try {
            for (Map.Entry<Integer, Player> me : playersMap.entrySet()) {

                int s1 =me.getValue().getPlayerID();
                String s2 =me.getValue().getPlayerName();
                String s3 =me.getValue().getPlayerTeam();
                String s4 =me.getValue().getPlayerPosition();
                int s5 =me.getValue().getPlayerValue();
                ArrayList s6 =me.getValue().getPlayerSeasonPoints();
                int s7 =me.getValue().getPlayerTotalPoints();

                writer.write(s1 + "~" + s2 + "~" + s3 + "~" + s4 + "~" + s5 + "~" + "[");
                for (int i = 0 ; i<s6.size() ; i++) {
                    if (i==s6.size()-1)
                        writer.write(s6.get(i) + "");
                    else
                        writer.write(s6.get(i) + ",");
                }
                writer.write("]" + "~" + s7 + ";\n");
            }
        }catch(NullPointerException x)
        {}
        writer.close();
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