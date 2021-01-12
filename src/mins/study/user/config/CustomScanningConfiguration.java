package mins.study.user.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = "mins.study.user.service.scanTarget",
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Service"),
        excludeFilters = @ComponentScan.Filter(Component.class)
)
public class CustomScanningConfiguration {
}
