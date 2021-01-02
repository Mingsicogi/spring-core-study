package mins.study.user.service;

public class TestServiceForBeanScope {

    private BeanScopeService beanScopeService;

    public void setBeanScopeService(BeanScopeService beanScopeService) {
        System.out.println("\nBeanScopeService Injection Complete");
        System.out.println("Message of BeanScopeService : " + beanScopeService.getMessage());
        this.beanScopeService = beanScopeService;
    }

    public BeanScopeService getBeanScopeService() {
        return beanScopeService;
    }
}
