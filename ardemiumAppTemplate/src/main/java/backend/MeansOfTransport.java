package backend;

import java.io.IOException;

public abstract class MeansOfTransport {

    String start;
    String eind;
    String medium;

    public int getUistoot(String start, String eind, String medium) throws IOException {
        this.start = start;
        this.eind = eind;
        this.medium = medium;
        return coTwee();
    }

    public abstract int coTwee() throws IOException;
}
