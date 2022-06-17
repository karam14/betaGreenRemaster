package backend;

public class Quote {
    public String QUOTEID;
    public String tip;
    public String quote;

    public Quote(String QUOTEID, String tip, String quote) {
        this.QUOTEID = QUOTEID;
        this.tip = tip;
        this.quote = quote;
    }

    public String getQUOTEID() {
        return QUOTEID;
    }

    public String getTip() {
        return tip;
    }

    public String getQuote() {
        return quote;
    }
}
