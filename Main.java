import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        User user1;  // general attributes
        String username;
        String password;

        String userPath = "Fantasy-Database\\UserDatabase.txt";     // PATHS
        String squadPath = "Fantasy-Database\\SquadDatabase.txt";
        String playerPath = "Fantasy-Database\\PlayerDatabase.txt";

        UserRepo userRepo = new UserRepo();      // REPOSITORIES
        SquadRepo squadRepo = new SquadRepo();
        PlayerRepo playerRepo = new PlayerRepo();

        userRepo.readFromFile(userPath);  // Reading from files
        squadRepo.readFromFile(squadPath);
        playerRepo.readFromFile(playerPath);

        Scanner stringInput = new Scanner(System.in);  // SCANNERS
        Scanner intInput = new Scanner(System.in);

        Registration register = new Registration(); // Registration
        System.out.println("Welcome To Premier League Fantasy 20/21");
        while(true)
        {
        System.out.println("To: \nSign up -> enter 1 \nLog in -> enter 2 \nExit -> enter 3"); // Outer Menu
        String userChoice = stringInput.nextLine();
        if(userChoice.equals("1"))  // SIGNUP PROCESS BEGIN
        {
            System.out.println("Enter Username");
            username = stringInput.nextLine();
            System.out.println("Enter Password");
            password = stringInput.nextLine();
            System.out.println("Enter Email");
            String Email = stringInput.nextLine();
            user1 = new User(username,Email,password);
            System.out.println("Enter your favorite team");
            String favTeam = stringInput.nextLine();
            user1.setFavoriteTeam(favTeam);
            while (!register.signUp(user1))
            {
                System.out.println("The username you entered is not available..Please choose another username");
                user1.setUsername(stringInput.nextLine());
            }
            System.out.println("Wohoo..Registration completed");
        }  // SIGNUP END
        else if(userChoice.equals("2"))      // LOGIN PROCESS BEGIN
        {
            System.out.println("Enter username :");
            username = stringInput.nextLine();
            System.out.println("Enter password");
            password = stringInput.nextLine();
                if (register.login(username, password)) // Username & password verification
                {
                    user1 = userRepo.usersMap.get(username);
                    System.out.println("Login succeded");
                        if (user1.getSquadID() == 0) // if user doesn't have a squad
                        {
                            String squadName;
                            int playerID;
                            System.out.println("You don't have a squad yet");
                            System.out.println("To: \nCreate a squad -> enter 1 \nlogout -> enter 2");  // Inner Menu
                            String choice = stringInput.nextLine();
                            if (choice.equals("1")) {
                                System.out.println("Enter your squad name");
                                squadName = stringInput.nextLine();
                                UserService u = new UserService();
                                u.createSquad(username, squadName);
                                for (int i = 1; i <= 15; i++) {
                                    System.out.println("enter player number " + i + " ID");
                                    playerID = intInput.nextInt();
                                    if(!u.addPlayerToSquad(username, playerID)) //Checking number of players in each position
                                    {
                                        System.out.println("max number exceeded..Can't add this player");
                                        i--;
                                    }
                                }
                                System.out.println("Squad created successfully");
                                System.out.println("welcome " + user1.getUsername() + " , Squad " + SquadRepo.squadMap.get(user1.getSquadID()).getSquadName());
                                break;
                            }
                            else if (choice.equals("2")) {
                                System.out.println("Logged out");
                                //break;
                            }
                        } else {   //if User have a Squad
                            System.out.println("welcome " + user1.getUsername() + " , Squad " + SquadRepo.squadMap.get(user1.getSquadID()).getSquadName());
                            break;
                        }
                } else {
                    System.out.println("Login failed");
                    System.out.println("Please check your credentials and try again");
                }
        }
        else if(userChoice.equals("3"))  // EXIT
        {
            break;
        }
        else{
            System.out.println("Please choose a valid option");
        }
        }
        userRepo.writeToFile(userPath);  // writing to files
        squadRepo.writeToFile(squadPath);
        playerRepo.writeToFile(playerPath);
    }
}