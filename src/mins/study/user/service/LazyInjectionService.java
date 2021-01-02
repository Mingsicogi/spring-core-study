package mins.study.user.service;

public class LazyInjectionService {
    private String message;

    public LazyInjectionService(String message) {
        this.message = message;

        System.out.println("Lazy initialization. message : " + message);
    }
}
