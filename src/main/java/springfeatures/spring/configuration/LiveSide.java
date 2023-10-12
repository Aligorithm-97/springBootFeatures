package springfeatures.spring.configuration;

public class LiveSide implements ISide {
    @Override
    public String givenSide(String name) {
        return "Live Beans Created" + " " + name;
    }
}
