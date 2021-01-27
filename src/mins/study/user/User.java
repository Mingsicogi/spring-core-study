package mins.study.user;


import org.springframework.context.ApplicationEvent;

public class User /*extends ApplicationEvent*/ {

    private String name;
    private String age;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
//    public User(Object source, String name, String age) {
//        super(source);
//        this.name = name;
//        this.age = age;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
