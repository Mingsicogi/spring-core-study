package mins.study.user.service;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Configuration
public class CustomScopeConfiguration {

    public CustomScopeConfiguration(DefaultListableBeanFactory factory, CustomScope customScope) {
        factory.registerScope("custom", customScope);
    }

//    @Scope(scopeName = "custom")
//    @Bean
    public CustomScopeService customScopeService() {
        return new CustomScopeService();
    }

//    @Scope(scopeName = "custom")
//    @Bean
    public Custom2ScopeService custom2ScopeService() {
        return new Custom2ScopeService();
    }
}
