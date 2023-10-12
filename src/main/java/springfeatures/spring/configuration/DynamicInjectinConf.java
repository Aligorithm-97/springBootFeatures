package springfeatures.spring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("live")
public class DynamicInjectinConf {
    @Value("${side.desc}")
    private String sidevalue;
    @Bean
    public ISide side(@Value("${which.side}") String side) {
        System.out.println(sidevalue);
        switch (side) {
            case "dev":
                return new DevelopmentSide();
            case "live":
            default:
                return new LiveSide();
        }
    }
}
