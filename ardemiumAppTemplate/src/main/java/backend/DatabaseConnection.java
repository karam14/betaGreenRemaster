package backend;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DatabaseConnection {
    Gson gson = new Gson();

    public ArrayList<User> getUserdb() throws FileNotFoundException {
        ArrayList<User> output = new ArrayList<>();
        Gson gson = new Gson();
        FileReader fileReader = new FileReader("ardemiumAppTemplate/src/main/resources/gsondb/userdb.json");
        JsonArray userdb = gson.fromJson(fileReader, JsonArray.class);
        for (JsonElement o :
                userdb) {
            output.add(gson.fromJson(o, User.class));
        }
        return output;
    }

    public void setUserdb(ArrayList<User> userdb) throws IOException {
        FileWriter fileWriter = new FileWriter("ardemiumAppTemplate/src/main/resources/gsondb/userdb.json");
        for (int i = 0; i < userdb.size(); i++) {
            userdb.get(i).USERID = i;
        }
        gson.toJson(userdb, fileWriter);
        fileWriter.close();
    }

    public void saveUser(String email, String password, String name, String phone) throws IOException {
        ArrayList<User> userdb = getUserdb();
        User user = new User(userdb.size(), email, password, name, phone);
        userdb.add(user);
        setUserdb(userdb);
    }

    public int[] validateUser(String email, String password) throws FileNotFoundException {
        int[] response = {-1, -1};
        ArrayList<User> userdb = getUserdb();
        for (User u :
                userdb) {
            if (u.password.equals(password) && u.email.equals(email)) {
                if (u.admin) {
                    response[0] = 1;
                    response[1] = u.USERID;
                } else {
                    response[0] = 0;
                    response[1] = u.USERID;
                }
            }
        }
        return response;
    }

    public boolean userExcist(String email) throws FileNotFoundException {
        boolean response = false;
        ArrayList<User> userdb = getUserdb();
        for (User u :
                userdb) {
            if (u.email.equals(email)) {
                response = true;
                return response;
            }
        }
        return response;
    }

    public User getUser(int[] validateToken) throws FileNotFoundException {
        ArrayList<User> userdb = getUserdb();
        for (User u :
                userdb) {
            if (u.USERID == validateToken[1]) {
                return u;
            }
        }
        return null;
    }

    public void changeUser(User user) throws IOException {
        ArrayList<User> userdb = getUserdb();
        for (User u :
                userdb) {
            if (u.USERID == user.USERID) {
                userdb.set(userdb.indexOf(u),user);
                break;
            }
        }
        setUserdb(userdb);
    }
    public ArrayList<Reward> getRewarddb() throws FileNotFoundException {
        ArrayList<Reward> output = new ArrayList<>();
        Gson gson = new Gson();
        FileReader fileReader = new FileReader("src/main/resources/gsondb/rewarddb.json");
        JsonArray rewarddb = gson.fromJson(fileReader, JsonArray.class);
        for (JsonElement o :
                rewarddb) {
            output.add(gson.fromJson(o, Reward.class));
        }
        return output;
    }

    public ArrayList<Quote> getQuotesdb() throws FileNotFoundException {
        ArrayList<Quote> output = new ArrayList<>();
        Gson gson = new Gson();
        FileReader fileReader = new FileReader("src/main/resources/gsondb/quotedb.json");
        JsonArray rewarddb = gson.fromJson(fileReader, JsonArray.class);
        for (JsonElement o :
                rewarddb) {
            output.add(gson.fromJson(o, Quote.class));
        }
        return output;
    }

}