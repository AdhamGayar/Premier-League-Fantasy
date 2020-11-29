import java.io.FileNotFoundException;
import java.util.Scanner;
// added playerTeam in Player, then handling input&output format in PLayerRepo          PLayer & PLayerRepo class
// added all players to the database with the new format                                 PlayerDatabase.txt
// added Repo interface , useless for now.. unless we add setters and getters for maps   Repo Interface (new)
// Registration class done, login and signUp functions                                   Registration CLass
// generic PC-username inside the passed path (system.getProperty() method)              Main Class
// handling the registration process in Main ..not complete yet ,,check next comment     Main Class
// TO-DO: setting Squad id for new user                                                  Main CLass
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\" + System.getProperty("user.name") +"\\Documents\\Fantasy-Database\\UserDatabase.txt";
        Scanner input = new Scanner(System.in);
        UserRepo userRepo = new UserRepo();
        User user1;
        String username;
        String password;
        userRepo.readFromFile(path);
        Registration register = new Registration();
        System.out.println("Welcome To Premier League Fantasy 20/21");
        System.out.println("Are you a current user? (Y/N)");
        String userChoice = input.nextLine();
        if(userChoice.compareToIgnoreCase("Y")==0) {
            System.out.println("Enter username :");
            username = input.nextLine();
            System.out.println("Enter password");
            password = input.nextLine();
                if (register.login(username, password)) {
                    user1 = userRepo.usersMap.get(username);
                    System.out.println("Login succeded");
                } else {
                    System.out.println("Login failed");
                    System.out.println("Please check your credentials and try again");
                }
        }
        else if(userChoice.compareToIgnoreCase("N")==0)
        {
            System.out.println("Do You want to signUp? (Y/N)");
            String choice = input.nextLine();
            if(choice.compareToIgnoreCase("Y") == 0)
            {
                System.out.println("Enter Username");
                username = input.nextLine();
                System.out.println("Enter Password");
                password = input.nextLine();
                System.out.println("Enter Email");
                String Email = input.nextLine();
                //squad id .. setting it is based on what???
                user1 = new User(username,Email,password,0);
                System.out.println("Enter your favorite team");
                String favTeam = input.nextLine();
                user1.setFavoriteTeam(favTeam);
                while (!register.signUp(user1))
                {
                    System.out.println("the username you entered is not available..Please choose another username");
                    user1.setUsername(input.nextLine());
                }
                System.out.println("Wohoo..Registration completed");
            }
            else {
                System.out.println("Registration failed");
            }
        }
        else{
            System.out.println("Login Failed");
        }
       userRepo.writeToFile(path);

    }
}


    /*String path = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Fantasy-Database\\nonformat.txt";
    ReposFormater(path);
    private static void ReposFormater(String path) throws FileNotFoundException {
        File file = new File(path);
        ArrayList<String> reader = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            reader.add(sc.nextLine());
        }
        int x=0;
        while (x<reader.size()-1) {
            String Line = reader.get(x);
            String information = "";
            int count = 0;
            Player p1 = new Player();
            for (int i = 0; i < Line.length(); i++) {
                if (Line.charAt(i) == '\t') {
                    switch (count) {
                        case 0:
                            p1.setPlayerName(information);
                            break;
                            case 1: p1.setPlayerTeam(information); break;
                        case 2:
                           p1.setPlayerTotalPoints(Integer.parseInt(information));
                            break;
                    }
                    count++;
                    information = "";
                } else {
                    information += Line.charAt(i);
                }
            }
            String Playervalue = Line.substring(Line.length()-3,Line.length()-2);
            String PlayerName =p1.getPlayerName();
            String PLayerTeam = p1.getPlayerTeam();
            int s4 =Integer.parseInt(Playervalue);
            int s6 =p1.getPlayerTotalPoints();
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Fantasy-Database\\formated.txt"),true));
            writer.write(x+260 + "~" + PlayerName + "~" + PLayerTeam +"~" + "FD" + "~" + s4 + "~" + 0 + "~" + s6 +";\n");
            writer.close();
            x++;
        }
    }*/