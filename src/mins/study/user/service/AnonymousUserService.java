package mins.study.user.service;

import mins.study.user.User;
import mins.study.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Required;

public class AnonymousUserService {

    private static AnonymousUserService anonymousUserService = new AnonymousUserService();
    private UserDao userDao;

    public AnonymousUserService(){
        System.out.println("AnonymousUserService Created");
    }

    public static AnonymousUserService createInstance() {
        return anonymousUserService;
    }

//    @Required
    public void setUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addAnonymousUser(User user) {
        userDao.add(user);
    }
}
