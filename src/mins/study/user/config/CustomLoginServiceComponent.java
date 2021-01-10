package mins.study.user.config;

import mins.study.user.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class CustomLoginServiceComponent {
    // Array injection example code
//    LoginService[] loginServices;
//    @Autowired(required = false)
//    public CustomLoginServiceComponent(LoginService[] loginServices) {
//        this.loginServices = loginServices;
//    }

    // Set injection example code
//    Set<LoginService> loginServices;
//    @Autowired(required = false)
//    public CustomLoginServiceComponent(Set<LoginService> loginServices) {
//        this.loginServices = loginServices;
//    }

    // Map injection example code
    Map<String, LoginService> loginServices;

    Optional<NotSingletonInstanceBean> notSingletonInstanceBean;

    @Autowired(required = false)
    public CustomLoginServiceComponent(Map<String, LoginService> loginServices) {
        this.loginServices = loginServices;
    }

    @Autowired
    public void setNotSingletonInstanceBean(Optional<NotSingletonInstanceBean> notSingletonInstanceBean) {

        if (notSingletonInstanceBean.isEmpty()) {
            System.out.println("NotSingletonInstanceBean 는 정의되지 않은 빈입니다.");
        }

        this.notSingletonInstanceBean = notSingletonInstanceBean;
    }

    public void supportingLoginService() {
        for (String key : loginServices.keySet()){
            System.out.println("key : " + key + ", value : " + loginServices.get(key));
        }

//        for (LoginService loginService : loginServices) {
//            System.out.println(loginService);
//        }
    }
}

