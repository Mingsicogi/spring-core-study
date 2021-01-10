# Spring Core Study

- Reference Document
    1. https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans
    
    
# About Web Scope
| Request Scope

```` 
@Controller
@RequestScope
@RequestMapping("/v1/api/beanScope")
@RequiredArgsConstructor
public class RequestScopeTest {

    private final ApplicationContext applicationContext;

    @GetMapping
    @ResponseBody
    public String test() {
        RequestScopeTest requestScopeTest = applicationContext.getBean("requestScopeTest", RequestScopeTest.class);
        System.out.println(requestScopeTest.toString());
        return "Request Scope";
    }
}
````
Console)

![image](screenshots/RequestScope.png)


| Session Scope
````
@SessionScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/sessionScope")
public class SessionScopeTest {

    private final ApplicationContext applicationContext;

    @GetMapping
    public String test(HttpServletRequest request) {
        SessionScopeTest requestScopeTest = applicationContext.getBean("sessionScopeTest", SessionScopeTest.class);
        System.out.println("session id : " + request.getSession().getId() + ", SessionScopeTest : " + requestScopeTest.toString());
        return "Session Scope";
    }
}
````

Console)

![image](screenshots/SessionScope.png)

//TODO Websocket Scope


| Application Scope

````
@ApplicationScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/applicationScope")
public class ApplicationScopeTest {

    private final ApplicationContext applicationContext;
    private static Integer counter = 0;

    private final WebApplicationContext webApplicationContext;

    @GetMapping
    public String test() {
        ApplicationScopeTest requestScopeTest = applicationContext.getBean("applicationScopeTest", ApplicationScopeTest.class);
        System.out.println(requestScopeTest.toString());

        if(counter++ >= 5) {
            webApplicationContext.getServletContext();
            //TODO Servlet 만 destroy 를 하고... 다시 startUp을 하면??!
        }

        return "Application Scope";
    }
}
````

This is somewhat similar to a Spring singleton bean but differs in two important ways: 
It is a singleton per ServletContext, not per Spring 'ApplicationContext' (for which there may be several in any given web application), and it is actually exposed and therefore visible as a ServletContext attribute.

-> TODO Servlet 을 reload 하면 Singleton Object가 새로 생길 거 같음(Spring Context는 유지한 체로..) 예제 코드 고민해 보기

---

# Container Extension
0. 1 ~ 3 까지 공통점은 multiple하게 설정해서 사용할 수 있고, Ordered interface를 통해 동작 순서를 정할 수 있음.

1. Customizing Beans by Using a BeanPostProcessor
해당 인터페이스를 implements하면, Spring Container 초기화, 설정, 인스턴스화 후에 추가적인 커스텀 작업을 할 수 있음

![image](screenshots/BeanPostProcessor.png)


2. Customizing Configuration Metadata
BeanPostProcessor와 유사한 기능이지만 가장 큰 차이는 bean configuration metadata에서 동작한다는 것!

properties 파일에 정의된 설정값을 object에 셋팅하고, spring context에서 관리하면서 다이나믹하게 사용할 수 있음(Override)

````
@Configuration
public class CustomizingConfigurationMetadata implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @DependsOn("redisProperties")
    @Bean
    public PropertyOverrideConfigurer propertyOverrideConfigurer() {
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setLocation(new ClassPathResource("properties/redis.properties"));
        return propertyOverrideConfigurer;
    }

    @Bean(value = {"redis", "redisProperties"})
    public RedisProperties redisProperties() {
        return new RedisProperties("localhost:6379", "0");
    }
}
````

3. FactoryBean
FactoryBean 을 implements 해서 오브젝트들을 팩토리화 할 수 있음. 이렇게 팩토리화 된 것은 스프링 컨테이너 인스터스 시점에 플러그인 처럼 쓸 수 있음.
만약에 초기화하는 로직이 복잡하다면 자바 코드로 팩토리화 하는 것도 좋음.

---

# Annotation-based Container Configuration

1. @Required (5.1 이후 @Deprecated)
 : Setter 메소드에서 주입을 강제하기 위해 사용됨
 
2. @Autowired (JSR 330's javax.inject 패키지의 @Inject 를 대신해 사용할 수 있음)
 : 생성자 or Setter 메소드에서 사용. (생성자에서 사용의 경우 4.3 이후 버전 부터는 정의된 빈이 한개라면, 따로 명시하지 않아도 됨)
 : required 옵션은 default true임. false로 설정하면, 
 
 
Example code of array field injection)
 
````
public class GoogleLoginServiceImpl implements LoginService {
}

public class FacebookLoginServiceImpl implements LoginService {
}

@Component
public class CustomLoginServiceComponent {

    LoginService[] loginServices;

    @Autowired(required = false)
    public CustomLoginServiceComponent(LoginService[] loginServices) {
        this.loginServices = loginServices;
    }

    public void supportingLoginService() {
        for (LoginService loginService : loginServices) {
            System.out.println(loginService);
        }
    }
}

Console Result)
mins.study.user.service.login.GoogleLoginServiceImpl@59f63e24
mins.study.user.service.login.FacebookLoginServiceImpl@61f05988
````


Example code of Set field injection)
 
````
public class GoogleLoginServiceImpl implements LoginService {
}

public class FacebookLoginServiceImpl implements LoginService {
}

@Component
public class CustomLoginServiceComponent {

    // Set injection example code
    Set<LoginService> loginServices;

    @Autowired(required = false)
    public CustomLoginServiceComponent(Set<LoginService> loginServices) {
        this.loginServices = loginServices;
    }

    public void supportingLoginService() {
        for (LoginService loginService : loginServices) {
            System.out.println(loginService);
        }
    }
}

Console Result)
mins.study.user.service.login.GoogleLoginServiceImpl@59f63e24
mins.study.user.service.login.FacebookLoginServiceImpl@61f05988
````


Example code of Map field injection)
 
````
public class GoogleLoginServiceImpl implements LoginService {
}

public class FacebookLoginServiceImpl implements LoginService {
}

@Component
public class CustomLoginServiceComponent {

    // Map injection example code
    Map<String, LoginService> loginServices;
    @Autowired(required = false)
    public CustomLoginServiceComponent(Map<String, LoginService> loginServices) {
        this.loginServices = loginServices;
    }
    
    public void supportingLoginService() {
        for (String key : loginServices.keySet()){
            System.out.println("key : " + key + ", value : " + loginServices.get(key));
        }
    }
}

Console Result)
mins.study.user.service.login.GoogleLoginServiceImpl@59f63e24
mins.study.user.service.login.FacebookLoginServiceImpl@61f05988
````

