package backend;

import java.util.ArrayList;

public class User {
    public int USERID;
    public boolean admin;
    public String email;
    public String password;
    public String name;
    public String phone;
    public int points;
    public Integer[] goals;
//    public ArrayList<MeansOfTransport>meansOfTransport;
    //    public ArrayList<Ride> rides;


    public User(int USERID, boolean admin) {
        this.email = email;
        this.admin = admin;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.USERID = USERID;
        this.points = points;
        this.goals = goals;
//        this.meansOfTransport = initMeansOfTransport();
//        this.rides = initMeansOfRides();
    }
//
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

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
