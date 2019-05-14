/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Encryption;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ludvig
 */
public abstract class UserMapper {

    public static UserMapper instance() {
        return UserDBMapper.getInstance();
    }

    public abstract void createUser(User user) throws LoginSampleException;


    public abstract User login(String email, String password) throws LoginSampleException;

    public abstract boolean verifyUser(String email, String password) throws LoginSampleException;

    public abstract void removeUser(User user) throws LoginSampleException;
    
    public abstract User getUserByEmail(String email) throws LoginSampleException;

    

    

    public static void main(String[] args) throws LoginSampleException {
//        UserMapper map = new UserMapper();
//        User user = new User("John123@johnmail.com", 5, "boss");
//        String password = "qwe";
//
//        System.out.println(map.verifyUser(user.getEmail(), password));
//        System.out.println(map.getUserByEmail(user.getEmail()));
    }

}
