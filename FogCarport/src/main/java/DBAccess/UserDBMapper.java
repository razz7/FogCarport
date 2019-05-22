package DBAccess;

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
public class UserDBMapper extends UserMapper{

    private Connector dbc = new Connector();

    private static UserDBMapper instance = null;

    public synchronized static UserDBMapper getInstance() {
        if (instance == null) {
            instance = new UserDBMapper();
        }
        return instance;
    }
    
    public void setMapperConnection(Connection connection) {
        dbc.setConnection(connection);
    }

    /**
     * Creates user and puts it into the database
     * @param email
     * @param password
     * @param role
     * @throws LoginSampleException 
     */
    @Override
    public void createUser(String email, String password, String role) throws LoginSampleException {
        try {
            Connection con = dbc.connection();
            String SQL = "INSERT INTO users (email, role, securepassword, salt) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            LogicFacade lcf = new LogicFacade();
            String salt = lcf.getEncryptWord(30);
            String mySecurePassword = lcf.generateSecurePassword(password, salt);
            ps.setString(1, email);
            ps.setString(2, role);
            ps.setString(3, mySecurePassword);
            ps.setString(4, salt);
            ps.executeUpdate();
                      
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    /**
     * Creates an object of a user already in the database
     * @param email
     * @param password
     * @return User
     * @throws LoginSampleException 
     */
    @Override
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
                User user = new User(email, id, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    /**
     * Removes specified user from the database
     * @param user
     * @throws LoginSampleException 
     */
    @Override
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

    /**
     * Gets user by email
     * @param email
     * @return
     * @throws LoginSampleException 
     */
    @Override
    public User getUserByEmail(String email) throws LoginSampleException {
        try {
            String sql = "select * from users where email=?";
            Connection conn = dbc.connection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getString(2), rs.getInt(1), rs.getString(3));
                return user;
            }
            return null;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    /**
     * Verifies whether a user is legit
     * @param email
     * @param password
     * @return boolean
     * @throws LoginSampleException 
     */
    @Override
    public boolean verifyUser(String email, String password) throws LoginSampleException {
        if(email == null || password == null || email == "" || password == "") {
        
        return false;
    }
        if(getUserByEmail(email) == null) {
                return false;
            }
        
        try {
            String sql = "select * from users where email=?";
            Connection conn = dbc.connection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            String securePassword = "";
            String salt = "";
            LogicFacade lfc = new LogicFacade();
            

            while (rs.next()) {
                securePassword = rs.getString(4);
                salt = rs.getString(5);
            }
            return lfc.verifyUserPassword(password, securePassword, salt);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());

        }
    }


    
    
}
