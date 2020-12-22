public class User {
    private String username;
    private String password;
    private String email;
    private String favoriteTeam;
    private int userBudget = 100;
    private int squadID = 0;
    User()
    {}
    User(String username, String email, String password)
    {
            this.username = username;
            this.password = password;
            this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFavoriteTeam() {
        return favoriteTeam;
    }

    public int getUserBudget() {
        return userBudget;
    }

    public int getSquadID() {
        return squadID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavoriteTeam(String favoriteTeam) {
        this.favoriteTeam = favoriteTeam;
    }

    public void setUserBudget(int userBudget) {
        this.userBudget = userBudget;
    }

    public void setSquadID(int squadID) {
        this.squadID = squadID;
    }
}
