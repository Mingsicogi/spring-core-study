package mins.study.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/properties/${spring.profiles.active:local}/common.properties")
public class PlaceholderResolutionConfiguration {
}
