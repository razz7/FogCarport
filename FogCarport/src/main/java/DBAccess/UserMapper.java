/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

/**
 *
 * @author Ludvig
 */
public abstract class UserMapper {

    public static UserMapper instance() {
        return UserDBMapper.getInstance();
    }

    public abstract void createUser(String email, String password, String role) throws LoginSampleException;

    public abstract User login(String email, String password) throws LoginSampleException;

    public abstract boolean verifyUser(String email, String password) throws LoginSampleException;

    public abstract void removeUser(User user) throws LoginSampleException;

    public abstract User getUserByEmail(String email) throws LoginSampleException;

    public abstract User getUserByID(int id) throws LoginSampleException;

}
