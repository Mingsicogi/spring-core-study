package mins.study.user.service;

public class BeanDefinitionInheritService {

    private String name;

    public BeanDefinitionInheritService() {
        System.out.println("\nBeanDefinitionInheritService Created");
    }

    public void setName(String name) {
        this.name = name;

        System.out.println("Setting Property | name : " + name + "\n");
    }
}
