package backend;

public final class SessionUser {
    private User user;
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
    }
}
