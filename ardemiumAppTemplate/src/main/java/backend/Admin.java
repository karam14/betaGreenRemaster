package backend;

public class Admin extends User {

    public Admin(User u) {
        super(u.USERID, u.email, u.password, u.name, u.phone);
    }
}
