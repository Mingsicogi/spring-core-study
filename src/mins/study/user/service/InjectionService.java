package mins.study.user.service;

import java.util.Map;

public class InjectionService {

    private Map<String, String> props;

    private String message;

    private String email;

    private String phone;

    public InjectionService(Map<String, String> props, String message, String email) {
        this.props = props;
        this.message = message;
        this.email = email;
        System.out.println("Constructor-Args Injection. \nKey List : " + String.join(",", props.keySet()) + "\n");

        System.out.println("c namespace Injection. \nmessage : " + message + ", email : " + email + "\n");
    }

    public void setPhone(String phone) {
        this.phone = phone;

        System.out.println("p namespace Injection. \nPhone : " + phone + "\n");
    }
}
