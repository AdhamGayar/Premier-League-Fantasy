public class Registration {
    private UserRepo userRepo;

    boolean login(String username, String password)
    {
        if(userRepo.usersMap.containsKey(username)) {
            if(userRepo.usersMap.get(username).getPassword().equals(password))
                return true;
            return false;
        }else
            return false;
    }
    boolean signUp(User user)
    {
        if(userRepo.usersMap.containsKey(user.getUsername())) {
            return false;
        }
        else{
            userRepo.usersMap.put(user.getUsername(), user);
            return true;
        }
    }
}
