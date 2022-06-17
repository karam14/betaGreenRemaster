package backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Admin extends User {
    public ArrayList<User>employees;
    public ArrayList<Quote>quotes;
    public ArrayList<Reward>allRewards;
     DatabaseConnection dc = new DatabaseConnection();
    public Admin(User u) throws FileNotFoundException {
        super(u.USERID, u.admin,u.email, u.password, u.name, u.phone,u.points,u.goals);
        this.employees = initEmployees();
        this.quotes = initQuotes();
        this.allRewards = initAllRewards();
    }

    public ArrayList<User> initEmployees() throws FileNotFoundException {
              return dc.getUserdb();
    }

    public ArrayList<Reward> initAllRewards() throws FileNotFoundException {
        return dc.getRewarddb();

    }

    public ArrayList<Quote> initQuotes() throws FileNotFoundException {
        DatabaseConnection dc = new DatabaseConnection();
        return dc.getQuotesdb();
    }


    public ArrayList<User> getEmployees() {
        return employees;
    }
}