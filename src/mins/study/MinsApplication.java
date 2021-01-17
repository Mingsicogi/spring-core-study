package mins.study;

import mins.study.user.User;
import mins.study.user.config.*;
import mins.study.user.dao.UserDao;
import mins.study.user.service.*;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.util.Locale;
import java.util.Optional;
import java.util.Properties;

/**
 * Spring Core study
 * https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans
 *
 */

public class MinsApplication {

    public static void main(String[] args) throws Exception {
        System.out.println("===== Now! Start Main Method =====");
        /** Introduction to the Spring IoC Container and Beans **/
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml", "application-context.xml");

        // 이렇게 IoC Container 에 등록된 빈들을 사용할 수 있지만 직접적으로 Spring API를 호출해 사용하는 코드는 사용할 필요가 없어야함.
        UserDao userDao = context.getBean("userDao", UserDao.class);
        UserService userService = context.getBean("userService", UserService.class);

        userService.userCheck(new User());
        userDao.add(new User());

        /** Naming Bean **/
        // java.beans.Introspector.decapitalize // bean 명명에 사용되는 메소드


        Class<?> userDao1 = context.getType("userService"); // actual runtime type of a particular bean

        /** Dependency Injection **/
        // spring에서는 생성자를 통한 주입을 권장함. 이유들 시스템이 실행되기 전에 null에 대한 체크를 할 수 있고, 코드에서 bad code small 을 확인할 수 있기 때문
        AnonymousUserService anonymousUserService = context.getBean("anonymousUserService", AnonymousUserService.class);
//        anonymousUserService.addAnonymousUser(new User());

        /** lazy initialize **/
        System.out.println("\n=== LAZY DI Start ===");
        LazyInjectionService lazyInjectionService = context.getBean("lazyInjectionService", LazyInjectionService.class);

        /** autowired **/
        AutowiredService autowiredService = context.getBean("autowiredService", AutowiredService.class);
        autowiredService.isInjectionService();

        /** bean scope **/
        BeanScopeService beanScopeService = context.getBean("beanScopeService", BeanScopeService.class);
        beanScopeService.setMessage("Bye");

        // lazy bean create singleton instance
        TestServiceForBeanScope testServiceForBeanScope = context.getBean("testServiceForBeanScope", TestServiceForBeanScope.class);

        // if BeanScopeService is singleton scope, the memory address value of singleton object will be the same, otherwise will not be the same.
        System.out.println("beanScopeService.toString() = " + beanScopeService.toString());
        System.out.println("testServiceForBeanScope.getBeanScopeService().toString() = " + testServiceForBeanScope.getBeanScopeService().toString());

//        ConfigurableBeanFactory configurableBeanFactory = context.getBean("configurableBeanFactory", ConfigurableBeanFactory.class);
//        configurableBeanFactory.registerScope("custom", new CustomScope());

        CustomScopeService customScopeService = context.getBean("customScopeService", CustomScopeService.class);
        Custom2ScopeService custom2ScopeService = context.getBean("custom2ScopeService", Custom2ScopeService.class);

        customScopeService.printer();
        customScopeService.printer();
        customScopeService.printer();
        custom2ScopeService.printer();
        custom2ScopeService.printer();
        custom2ScopeService.printer();

        // destroy bean
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DisposableBeanConfiguration.class);
        annotationConfigApplicationContext.registerShutdownHook();

        // LifeCycleProcessor(implements LifeCycle) 를 통해서 LifeCycle interface를 구현한 모든 클래스에게 start signal을 전파함.
        // SmartLifecycle 는 phase 순으로 시작됨. int 값이 낮은 순부터.. 멈출땐 역순으로 멈춤(int값이 큰 순으로).
        // LifeCycle 을 implements 한 클래스의 경우 phase를 0으로 설정됨. 때문에 LifeCycle 구현 클래스보다 앞에 설정을 추가하기 위해선 음수값을 이용해야함.

        // ApplicationContextAware => Aware

//        PropertySourcesPlaceholderConfigurer jdbcProperty = context.getBean("jdbcProperty", PropertySourcesPlaceholderConfigurer.class);
//        PropertySource<?> propertySource = jdbcProperty.getAppliedPropertySources().get("jdbcProperty");
//        String property = String.valueOf(propertySource.getProperty("jdbc.url"));

        System.out.println("\n\n==============================================================================================\n\n");
//        RedisProperties redisProperties = context.getBean("redisProperties", RedisProperties.class);
//        redisProperties.setDbNo("0");
//        redisProperties.setHost("localhost:6379");

        custom2ScopeService.printer();

        CustomBeanObject customBeanObject = context.getBean("customBeanObject", CustomBeanObject.class);
        System.out.println("=======> " + customBeanObject.getMessage());
        System.out.println();

        CustomBeanObject customBeanObject2 = context.getBean("customBeanObject", CustomBeanObject.class);
        System.out.println("=======> " + customBeanObject2.getMessage());
        System.out.println();

        CustomLoginServiceComponent customLoginServiceComponent = context.getBean("customLoginServiceComponent", CustomLoginServiceComponent.class);
        customLoginServiceComponent.supportingLoginService();

        MultipleSameTypeBeanService multipleSameTypeBeanService = context.getBean("multipleSameTypeBeanService", MultipleSameTypeBeanService.class);
        System.out.println(">>>>>>>>>>>>>>>>>> " + multipleSameTypeBeanService.getMovieCategory().getMyServiceName());
        System.out.println(">>>>>>>>>>>>>>>>>> " + multipleSameTypeBeanService.getDefaultMovieCategory().getMyServiceName());
        System.out.println(">>>>>>>>>>>>>>>>>> " + multipleSameTypeBeanService.getFourthMovieCategory().getMyServiceName());
        System.out.println(">>>>>>>>>>>>>>>>>> " + multipleSameTypeBeanService.getFifthMovieCategory().getMyServiceName());


        System.out.println("\n");

        GenericAutowiringService genericAutowiringService = context.getBean("genericAutowiringService", GenericAutowiringService.class);
        genericAutowiringService.printInstanceType();

        System.out.println();
        System.out.println();

        LookUpMethodInjectionConfiguration.CommandManager addCommand = context.getBean("add", LookUpMethodInjectionConfiguration.CommandManager.class);
        addCommand.executeCommand();

        LookUpMethodInjectionConfiguration.CommandManager subCommand = context.getBean("sub", LookUpMethodInjectionConfiguration.CommandManager.class);
        subCommand.executeCommand();

        LookUpMethodInjectionConfiguration.CommandManager mulCommand = context.getBean("mul", LookUpMethodInjectionConfiguration.CommandManager.class);
        mulCommand.executeCommand();

        System.out.println();
        System.out.println();
        EnvironmentAbstractConfiguration.NormalService normalService = context.getBean("normalService", EnvironmentAbstractConfiguration.NormalService.class);
        normalService.printer();

        System.out.println("redis.port contains ? " + context.getEnvironment().containsProperty("redis.port"));
        System.out.println("jdbc.url contains ? " + context.getEnvironment().containsProperty("jdbc.url"));

        System.out.println("ehcache.common.expire contains ? " + context.getEnvironment().containsProperty("ehcache.common.expire"));
        System.out.println("This environment : " + context.getEnvironment().getRequiredProperty("env"));

        MessageSource messageSource = new ClassPathXmlApplicationContext("beans.xml");
        String message = messageSource.getMessage("message", null, "DEFAULT", Locale.KOREA);
        System.out.println("MessageSource context : " + message);
    }
}
