package mins.study.user.config;

import mins.study.user.service.login.FacebookLoginServiceImpl;
import mins.study.user.service.login.GoogleLoginServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "mins.study.user.service.scanTarget",
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {GoogleLoginServiceImpl.class, FacebookLoginServiceImpl.class}),
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".Naver*")
)
public class ServiceAutoDetectConfiguration {
}
