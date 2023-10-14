package springfeatures.spring.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springfeatures.spring.service.CustomerService;

@Configuration
@Profile("live")
@EnableScheduling
@RequiredArgsConstructor
public class DynamicInjectinConf {
    private final CustomerService customerService;
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

    @Scheduled(cron = "0 * * * * *")
    public void scheduledTask(){
        customerService.changeCustomerVisibilityStatus();
        System.out.println("scheduled task running!");
    }
}
