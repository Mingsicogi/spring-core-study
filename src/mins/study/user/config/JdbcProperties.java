package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class JdbcProperties {

//    @Bean
//    public PropertySourcesPlaceholderConfigurer jdbcProperty() {
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("properties/jdbc.properties"));
////        propertySourcesPlaceholderConfigurer.getAppliedPropertySources()
//        return propertySourcesPlaceholderConfigurer;
//    }
}
