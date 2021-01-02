package mins.study.user.service;

public class SetterInjectionLifeCycleService {

    private String message;

    public void setMessage(String message) {
        this.message = message;
        System.out.println("Setting message : " + message);
    }
}
