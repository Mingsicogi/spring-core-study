package mins.study.user.service;

public class DefaultServiceLocator {

    private static AnonymousUserService anonymousUserService = new AnonymousUserService();

    public AnonymousUserService createAnonymousUserServiceInstance() {
        return anonymousUserService;
    }

}
