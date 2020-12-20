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
        System.out.println("Are you a current user? (Y/N)"); // login or signup
        String userChoice = stringInput.nextLine();
        if(userChoice.compareToIgnoreCase("Y")==0)      // LOGIN PROCESS BEGIN
        {
            System.out.println("Enter username :");
            username = stringInput.nextLine();
            System.out.println("Enter password");
            password = stringInput.nextLine();
                if (register.login(username, password)) // Username & password verification
                {
                    user1 = userRepo.usersMap.get(username);
                    System.out.println("Login succeded");

                    //NEW
                    if(user1.getSquadID()==0)
                    {
                        String squadName;
                        int playerID;
                        System.out.println("You don't have a squad yet");
                        System.out.println("Do you want to create a squad? (Y/N)");
                        String choice = stringInput.nextLine();
                        if(choice.compareToIgnoreCase("Y") == 0) {
                            System.out.println("Enter your squad name");
                            squadName = stringInput.nextLine();
                            UserService u = new UserService();
                            u.createSquad(username, squadName);
                            for (int i = 0; i < 15; i++) {
                                System.out.println("enter player number " + i + " ID");
                                playerID = intInput.nextInt();
                                u.addPlayerToSquad(playerID);
                            }
                            System.out.println("Squad created successfully");
                        }
                    }
                    else
                    {
                        System.out.println("welcome: " + user1.getUsername() + " ,Squad: " + SquadRepo.squadMap.get(user1.getSquadID()).getSquadName());
                    }

                    ///////////////////////////////////////////

                } else {
                    System.out.println("Login failed");
                    System.out.println("Please check your credentials and try again");
                }
        }
        else if(userChoice.compareToIgnoreCase("N")==0)  // SIGNUP PROCESS BEGIN
        {
            System.out.println("Do You want to signUp? (Y/N)");
            String choice = stringInput.nextLine();
            if(choice.compareToIgnoreCase("Y") == 0)
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
                    System.out.println("the username you entered is not available..Please choose another username");
                    user1.setUsername(stringInput.nextLine());
                }
                System.out.println("Wohoo..Registration completed");
            }
            else {
                System.out.println("Registration failed");
            }
        }  // SIGNUP END
        else{
            System.out.println("Login Failed");
        }
        userRepo.writeToFile(userPath);  // writing to files
        squadRepo.writeToFile(squadPath);
        playerRepo.writeToFile(playerPath);
    }
}
