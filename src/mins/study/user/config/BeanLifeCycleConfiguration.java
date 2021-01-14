package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class BeanLifeCycleConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Description("전처리 록 빈등")
    public PreProcess pre() {
        return new PreProcess();
    }
}

class PreProcess {

    public void init() {
        System.out.println("PreProcess class initialized");
    }

    public void destroy() {
        System.out.println("PreProcess class destroyed");
    }
}
