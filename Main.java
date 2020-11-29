import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       // this is a commit from intellij
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
