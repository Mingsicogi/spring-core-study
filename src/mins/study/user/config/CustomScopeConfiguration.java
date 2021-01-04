package mins.study.user.config;

import mins.study.user.service.Custom2ScopeService;
import mins.study.user.service.CustomScopeService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomScopeConfiguration {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new CustomScopeBeanFactoryPostProcessor();
    }

    @Scope(scopeName = "custom")
    @Bean
    public CustomScopeService customScopeService() {
        return new CustomScopeService();
    }

    @Scope(scopeName = "custom")
    @Bean
    public Custom2ScopeService custom2ScopeService() {
        return new Custom2ScopeService();
    }
}
