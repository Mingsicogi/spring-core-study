package mins.study.user.config;

import mins.study.user.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
