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

//    public boolean verifyUser(String email, String password) throws LoginSampleException {
//        try{
//            String sql = "select * from users where email=?";
//            Connection conn = dbc.connection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, email);
//            ResultSet rs = ps.executeQuery();
//            String securePassword = "";
//            String salt = "";
//            LogicFacade lfc = new LogicFacade();
//            
//            
//                    
//            while(rs.next()) {
//                securePassword = rs.getString(4);
//                salt = rs.getString(5);
//                
//            }
//            
//            if(securePassword != "" && salt != "") {
//            return lfc.verifyUserPassword(password, securePassword, salt);
//            }
//                    
//            
//        } catch(SQLException | ClassNotFoundException ex) {
//            throw new LoginSampleException(ex.getMessage());
//        
//    }
//        return false;
//    }
    
//    public void removeUser(User user) throws LoginSampleException {
//        try {
//            Connection con = dbc.connection();
//            String SQL = "DELETE FROM `useradmin`.`user`WHERE email=? AND password=?";
//            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, user.getEmail());
//            ps.setString(2, user.getPassword());
//            ps.executeUpdate();
//        } catch (SQLException | ClassNotFoundException ex) {
//            throw new LoginSampleException(ex.getMessage());
//        }
//        
//    }

    
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
