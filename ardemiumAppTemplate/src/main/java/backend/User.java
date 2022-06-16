package backend;

import java.util.ArrayList;

public class User {
    public int USERID;
    public boolean admin = false;
    public String email;
    public String password;
    public String name;
    public String phone;
    public ArrayList<MeansOfTransport>meansOfTransport;
//    public ArrayList<Ride> rides;
    public DatabaseConnection dc;

    public User(int USERID, String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.USERID = USERID;
//        this.meansOfTransport = initMeansOfTransport();
//        this.rides = initMeansOfRides();
    }

//    private ArrayList<MeansOfTransport> initMeansOfTransport() {
//    }
//
//    private ArrayList<Ride> initMeansOfRides() {
//    }

    @Override
    public String toString() {
        return  "ID=" + USERID +
                ", admin=" + admin +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone;
    }
}
