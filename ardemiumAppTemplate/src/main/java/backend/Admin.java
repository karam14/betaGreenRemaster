package backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<User>employees;
    private ArrayList<Quote>quotes;
    private ArrayList<Reward>allRewards;
    private DatabaseConnection dc = new DatabaseConnection();
    public Admin(User u) throws FileNotFoundException {
        super(u.USERID, u.email, u.password, u.name, u.phone);
        this.employees = initEmployees();
        this.quotes = initQuotes();
        this.allRewards = initAllRewards();
    }

    private ArrayList<User> initEmployees() throws FileNotFoundException {
        return dc.getUserdb();
    }

    private ArrayList<Reward> initAllRewards() throws FileNotFoundException {
        return dc.getRewarddb();

    }

    private ArrayList<Quote> initQuotes() throws FileNotFoundException {
        return dc.getQuotesdb();
    }


}
