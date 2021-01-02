package mins.study.user.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * TODO bean scope 학습 후 1.4.6 다시 예제 코드 만들기
 * https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-method-injection
 *
 */
public class MethodInjectionService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
