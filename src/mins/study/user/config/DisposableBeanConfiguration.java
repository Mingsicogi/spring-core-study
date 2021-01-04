package mins.study.user.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DisposableBeanConfiguration implements CommonConfiguration, DisposableBean {

    @Override
    public void destroy() throws Exception {
        print();
        System.out.println("============== Finish work and shutdown server... ================");
    }
}
