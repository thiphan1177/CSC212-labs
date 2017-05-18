public enum Who{
    ERIN("erin"),
    RIPE("ripe bananas"),
    APPLE("apple of my eye"),
    AFRICA("africa is a continent"),
    LAURA("laura was my classmate"),
    JAPAN("japan has sushi"),
    KRONK("kronk is awesome"),
    CALLME("call me maybe"),
    UNKNOWN("I don't know");

    private String url;

    Who(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
