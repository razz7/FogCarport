package FunctionLayer;

import DBAccess.UserDBMapper;

/**
 *
 * @author Rasmus2
 */
public class LogicFacade {

    public User login(String email, String password) throws LoginSampleException {
        UserDBMapper userMap = new UserDBMapper();
        return userMap.login(email, password);
    }

    public User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserDBMapper userMap = new UserDBMapper();
        userMap.createUser(user);
        return user;
    }
}
