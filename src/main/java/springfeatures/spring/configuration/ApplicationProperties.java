package springfeatures.spring.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import springfeatures.spring.entity.models.Customer;

import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "conf.prop")
public class ApplicationProperties {
    private String clientHost;
    private Map<String, Customer> customerMap;

}
