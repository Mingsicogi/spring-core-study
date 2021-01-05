package mins.study.user.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * Spring container initiating, configuring and instantiating 이후 추가 커스텀 설정을 BeanPostProcessor를 implements하면 할 수 있음.
 *
 */
@Configuration
public class CustomizingBeanConfiguration implements BeanPostProcessor, Ordered {

    public CustomizingBeanConfiguration() {

        System.out.println("CustomizingBeanConfiguration Created");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(String.format("=========== CustomizingBeanConfiguration Before | bean : %s, beanName : %s ===========", bean.toString(), beanName));
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(String.format("=========== CustomizingBeanConfiguration After | bean : %s, beanName : %s ===========", bean.toString(), beanName));
        return bean;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
