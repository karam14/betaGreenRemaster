package backend;

public abstract class MeansOfTransport {
    public int getUistoot(String start, String eind) {
        setStartPunt(start);
        setEindPunt(eind);
        return coTwee();
    }

    public abstract void setStartPunt(String start);

    public abstract void setEindPunt(String eind);

    public abstract int coTwee();
}
