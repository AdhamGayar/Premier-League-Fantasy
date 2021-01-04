import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    private static void endGameWeek(int gameweek)
    {
        SquadRepo squad = new SquadRepo();
        String path= "Fantasy-Database\\Squad-History\\gameweek" + gameweek + ".txt";
        try {
            squad.writeToFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {

        User user1;  // general attributes
        String username;
        String password;

        String userPath = "Fantasy-Database\\UserDatabase.txt";     // PATHS
        String squadPath = "Fantasy-Database\\SquadDatabase.txt";
        String playerPath = "Fantasy-Database\\PlayerDatabase.txt";
        String matchPath = "Fantasy-Database\\MatchDatabase.txt";

        Repo userRepo = new UserRepo();      // REPOSITORIES
        Repo squadRepo = new SquadRepo();
        Repo playerRepo = new PlayerRepo();
        Repo matchRepo = new MatchRepo();

        userRepo.readFromFile(userPath);  // Reading from files
        squadRepo.readFromFile(squadPath);
        playerRepo.readFromFile(playerPath);
        matchRepo.readFromFile(matchPath);


       /* EventManager eventManager = new EventManager();
        eventManager.startMatch("ARSvAVL");
        eventManager.scoreGoal(548,"ARSvAVL");
        eventManager.assistGoal(12,"ARSvAVL");
        eventManager.concedeGoal("away","ARSvAVL");
        eventManager.missPenalty(580,"ARSvAVL");
        eventManager.savePenalty(10,"ARSvAVL");
        eventManager.receiveCard("red",118,"ARSvAVL","home");
        eventManager.receiveCard("yellow",169,"ARSvAVL","away");
        eventManager.substitute(311,404,62,"home","ARSvAVL");
        eventManager.cleanSheet("home","ARSvAVL");
        eventManager.endMatch("ARSvAVL");*/

        Scanner stringInput = new Scanner(System.in);  // SCANNERS
        Scanner intInput = new Scanner(System.in);

        Registration register = new Registration(); // Registration
        System.out.println("Welcome To Premier League Fantasy 20/21");
        while(true)
        {
        System.out.println("To: \nSign up -> enter 1 \nLog in -> enter 2 \nAdd New Player -> enter 3\nExit -> enter 4"); // Outer Menu
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
                    user1 = UserRepo.usersMap.get(username);
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

                                    System.out.println("which Position are you looking for?");
                                    choice = stringInput.nextLine();
                                    while(!u.printPlayers(choice))
                                        choice = stringInput.nextLine();

                                    System.out.println("enter player number " + i + " ID");
                                    playerID = intInput.nextInt();
                                    try
                                    {
                                    if(!u.addPlayerToSquad(username, playerID)) //Checking number of players in each position
                                    {
                                        System.out.println("max number exceeded..Can't add this player");
                                        i--;
                                    }
                                    }
                                    catch(NullPointerException x){
                                        System.out.println("Index Out Of Bound");
                                        i--;
                                    }
                                }
                                SquadRepo.squadMap.get(user1.getSquadID()).autoFillMainSquad();
                                System.out.println("Squad created successfully");
                                System.out.println("welcome " + user1.getUsername() + " , Squad " + SquadRepo.squadMap.get(user1.getSquadID()).getSquadName());
                                break;
                            }
                            else if (choice.equals("2")) {
                                System.out.println("Logged out");
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
        else if(userChoice.equals("3"))  //Add New Player
        {
            PlayerService pService = new PlayerService();
            pService.addNewPlayer();
        }
        else if(userChoice.equals("4"))  // EXIT
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