package mins.study.user.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeBeanConfiguration implements CommonConfiguration, InitializingBean {

    public InitializeBeanConfiguration() {
        System.out.println("====== Ready to start... ======");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        print();
        System.out.println("======================== Start additional configuration after Spring Container set=========================");
    }
}
