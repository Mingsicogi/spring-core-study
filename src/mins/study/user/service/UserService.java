package mins.study.user.service;

import mins.study.user.User;
import mins.study.user.dao.UserDao;

public class UserService {

    private UserDao userDao;
    private CustomScopeService customScopeService;

    public UserService(UserDao userDao, CustomScopeService customScopeService) {
        this.userDao = userDao;
        this.customScopeService = customScopeService;
        System.out.println("UserService Created");
    }

    public void userCheck(User user) {
        System.out.println("Check user... ...");
    }
}
