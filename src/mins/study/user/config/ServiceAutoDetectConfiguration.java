package mins.study.user.config;

import mins.study.user.service.CommonComponentService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {CommonComponentService.class})
public class ServiceAutoDetectConfiguration {
}
