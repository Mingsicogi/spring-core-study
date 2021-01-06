package mins.study.user.service;

import mins.study.user.config.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Custom2ScopeService {

    @Value("${jdbc.url}")
    private String url;

    @Autowired
    private RedisProperties redisProperties;

    public void printer() {
        System.out.println("Custom2 Scope Service Print Message.");
        System.out.println(">>>>>>>>>>> JDBC URL : " + url);
        System.out.println(">>>>>>>>>>> REDIS HOST : " + redisProperties.getHost());
    }
}
