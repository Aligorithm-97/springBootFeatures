package springfeatures.spring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@Profile("live")
@EnableScheduling
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

    @Scheduled(fixedDelay = 10_000)
    public void scheduledTask(){
        System.out.println("scheduled task running!");
    }
}
