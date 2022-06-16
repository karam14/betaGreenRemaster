package backend;

public final class SessionUser {
    private User user;
    private Admin admin;
    private final static SessionUser INSTANCE = new SessionUser();

    private SessionUser() {
    }

    public static SessionUser getInstance() {
        return INSTANCE;
    }

    public void setUser(User u) {
        this.user = u;
    }

    public User getUser() {
        return this.user;
    }

    public void clearUser() {
        user = null;
        admin = null;
    }
    public void setAdmin(Admin u) {
        this.user = u;
        this.admin = u;
    }

    public Admin getAdmin() {
        return this.admin;
    }


}
