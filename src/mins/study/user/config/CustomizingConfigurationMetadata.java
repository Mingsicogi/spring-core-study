package mins.study.user.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class CustomizingConfigurationMetadata implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @DependsOn("redisProperties")
    @Bean
    public PropertyOverrideConfigurer propertyOverrideConfigurer() {
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setLocation(new ClassPathResource("properties/redis.properties"));
        return propertyOverrideConfigurer;
    }

    @Bean(value = {"redis", "redisProperties"})
    public RedisProperties redisProperties() {
        return new RedisProperties("localhost:6379", "0");
    }
}
