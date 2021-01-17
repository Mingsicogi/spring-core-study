package mins.study.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:/properties/ehcache.properties"})
public class PropertySourceConfiguration {
}
