package mins.study.user.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanScopeService implements InitializingBean, DisposableBean {

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

    @Override
    public void destroy() throws Exception {
        System.out.println("================ Destroy BeanScopeService.... ================");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("================ afterPropertiesSet BeanScopeService.... ================");
    }
}
