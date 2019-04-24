package FunctionLayer;

import DBAccess.UserMapper;

/**
 *
 * @author Rasmus2
 */
public class LogicFacade {

    public User login(String email, String password) throws LoginSampleException {
        UserMapper userMap = new UserMapper();
        return userMap.login(email, password);
    }

    public User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper userMap = new UserMapper();
        userMap.createUser(user);
        return user;
    }
}
