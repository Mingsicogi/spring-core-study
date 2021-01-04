package mins.study.user.service;

public class AutowiredService {

    private InjectionService injectionService;

    public AutowiredService(InjectionService injectionService) {
        this.injectionService = injectionService;
        System.out.println("AutowiredService Created");
    }

//    public void setInjectionService(InjectionService injectionService) {
//        this.injectionService = injectionService;
//    }

    public void isInjectionService() {
        if(injectionService != null)
            System.out.println("InjectionService Injection !!!");
        else
            System.out.println("Not Injected...");
    }
}
