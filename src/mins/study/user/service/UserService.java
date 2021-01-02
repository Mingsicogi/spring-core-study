package mins.study.user.service;

import mins.study.user.User;
import mins.study.user.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
        System.out.println("UserService Created");
    }

    public void userCheck(User user) {
        System.out.println("Check user... ...");
    }
}
