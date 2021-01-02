# Spring Core Study

- Reference Document
    1. https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans
    
    


# 
Bean Scope

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

![image](./RequestScope.png)
