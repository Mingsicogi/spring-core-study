package mins.study;

import mins.study.user.User;
import mins.study.user.config.DisposableBeanConfiguration;
import mins.study.user.dao.UserDao;
import mins.study.user.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        annotationConfigApplicationContext.close();
    }
}
