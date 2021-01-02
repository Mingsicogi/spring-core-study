package mins.study.user.service;

public class BeanScopeService {

    private String message;

    public BeanScopeService(String message) {
        this.message = message;
        System.out.println("BeanScopeService Created. message : " + message);
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
