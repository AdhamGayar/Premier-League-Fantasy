import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserRepo implements Repo{
    public static Map<String,User> usersMap = new HashMap<String,User>();

    public void readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String Line="";
        String information="";
        while (sc.hasNextLine())
        {
            Line=sc.nextLine();
            int count=0;
            User u1 = new User();
            for(int i=0;i<Line.length();i++) {
                if (Line.charAt(i) == '~') {
                    switch (count) {
                        case 0:u1.setUsername(information);break;
                        case 1:u1.setPassword(information);break;
                        case 2:u1.setEmail(information);break;
                        case 3:u1.setFavoriteTeam(information);break;
                        case 4:u1.setUserBudget(Integer.parseInt(information));break;
                    }
                    count++;
                    information="";
                }
                else if(Line.charAt(i)==';')
                {
                    u1.setSquadID(Integer.parseInt(information));
                    usersMap.put(u1.getUsername(),u1);
                    information="";
                }
                else
                {
                    information+=Line.charAt(i);
                }
            }
        }
        /*for (Map.Entry<String, User> me : usersMap.entrySet()) {
            User u3;
            u3=me.getValue();
            System.out.println(u3.getUsername()+" "+u3.getPassword()+" "+u3.getEmail()+" "+u3.getFavoriteTeam()+" "+u3.getUserBudget()+" "+u3.getSquadID());
        }*/
    }
    public void writeToFile(String path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(path));
       try {
           for (Map.Entry<String, User> me : usersMap.entrySet()) {

               String s1 =me.getValue().getUsername();
               String s2 =me.getValue().getPassword();
               String s3 =me.getValue().getEmail();
               String s4 =me.getValue().getFavoriteTeam();
               int s5 =me.getValue().getUserBudget();
               int s6 =me.getValue().getSquadID();

               writer.write(s1 + "~" + s2 + "~" + s3 + "~" + s4 + "~" + s5 + "~" + s6 +";\n");
           }
       }catch(NullPointerException x)
       {}
        writer.close();
    }
}
