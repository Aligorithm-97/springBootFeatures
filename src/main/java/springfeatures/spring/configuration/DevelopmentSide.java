package springfeatures.spring.configuration;

public class DevelopmentSide implements ISide {
    @Override
    public String givenSide(String name) {
        return "Development Beans Created" + " " + name;
    }
}
