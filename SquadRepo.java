import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SquadRepo implements Repo{
    public static Map<Integer, Squad> squadMap = new HashMap<Integer, Squad>();

    public void readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String Line = "";
        String information = "";
        while (sc.hasNextLine()) {
            Line = sc.nextLine();
            int count = 0;
            Squad s1 = new Squad();
            for (int i = 0; i < Line.length(); i++) {
                if (Line.charAt(i) == '~') {
                    switch (count) {
                        case 0:
                            s1.setSquadID(Integer.parseInt(information));
                            break;
                        case 1:
                            s1.setSquadName(information);
                            break;
                        case 2:
                            s1.setSquadValue(Integer.parseInt(information));
                            break;
                        case 3:
                            s1.setNumOfPlayers(Integer.parseInt(information));
                            break;
                        case 4:
                            s1.setSquadCaptainID(Integer.parseInt(information));
                            break;
                        case 5:
                            s1.setCurrentNoGK(Integer.parseInt(information));
                            break;
                        case 6:
                            s1.setCurrentNoDF(Integer.parseInt(information));
                            break;
                        case 7:
                            s1.setCurrentNoMF(Integer.parseInt(information));
                            break;
                        case 8:
                            s1.setCurrentNoFD(Integer.parseInt(information));
                            break;
                        case 9:
                            s1.setListOfPlayerID(readArrayFromFile(information));
                            break;
                    }
                    count++;
                    information = "";
                }
                else if (Line.charAt(i) == ';') {
                    s1.setMainSquad(readArrayFromFile(information));
                    squadMap.put(s1.getSquadID(),s1);
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

    public void writeToFile(String path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(path));
        try {
            for (Map.Entry<Integer, Squad> me : squadMap.entrySet()) {

                int s1 = me.getValue().getSquadID();
                String s2 = me.getValue().getSquadName();
                int s3 = me.getValue().getSquadValue();
                int s4 = me.getValue().getNumOfPlayers();
                int s5 = me.getValue().getSquadCaptainID();
                int s6 = me.getValue().getCurrentNoGK();
                int s7 = me.getValue().getCurrentNoDF();
                int s8 = me.getValue().getCurrentNoMF();
                int s9 = me.getValue().getCurrentNoFD();
                ArrayList s10 = me.getValue().getListOfPlayerID();
                ArrayList s11 = me.getValue().getMainSquad();

                writer.write(s1 + "~" + s2 + "~" + s3 + "~" + s4 + "~" + s5 + "~" + s6 + "~" + s7 + "~" + s8 + "~" + s9 + "~" + "[");
                for (int i = 0 ; i<s10.size() ; i++) {
                    if (i==s10.size()-1)
                        writer.write(s10.get(i) + "");
                    else
                        writer.write(s10.get(i) + ",");
                }
                writer.write("]" + "~" + "[");

                for (int i = 0 ; i<s11.size() ; i++) {
                    if (i==s11.size()-1)
                        writer.write(s11.get(i) + "");
                    else
                        writer.write(s11.get(i) + ",");
                }
                writer.write("]" + ";\n");
            }
        } catch (NullPointerException x) {
        }
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
