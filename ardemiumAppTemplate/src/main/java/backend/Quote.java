package backend;

public class Quote {
    final String QUOTEID;
    private String tip;
    private String quote;

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
