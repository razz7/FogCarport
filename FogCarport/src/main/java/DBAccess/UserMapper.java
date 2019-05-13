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
 * @author Rasmus2
 */
public class UserMapper {

    private Connector dbc = new Connector();

    public void createUser(User user) throws LoginSampleException {
        try {
            Connection con = dbc.connection();
            String SQL = "INSERT INTO users (email, role, securepassword, salt) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            LogicFacade lcf = new LogicFacade();
            String salt = lcf.getSalt(30);
            String mySecurePassword = lcf.generateSecurePassword(user.getPassword(), salt);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getRole());
            ps.setString(3, mySecurePassword);
            ps.setString(4, salt);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public boolean verifyUser(String email, String password) throws LoginSampleException {
        try{
            String sql = "select * from users where email=?";
            Connection conn = dbc.connection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            String securePassword = "";
            String salt = "";
            LogicFacade lfc = new LogicFacade();
                    
            while(rs.next()) {
                securePassword = rs.getString(4);
                salt = rs.getString(5);
                
            }
            return lfc.verifyUserPassword(password, securePassword, salt);
            
        } catch(SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public void removeUser(User user) throws LoginSampleException {
        try {
            Connection con = dbc.connection();
            String SQL = "DELETE FROM `useradmin`.`user`WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static void main(String[] args) throws LoginSampleException {
        UserMapper map = new UserMapper();
        User user = new User("John123@johnmail.com", "qweq", "boss");
        
        
     System.out.println(map.verifyUser(user.getEmail(), user.getPassword()));
    }

}
