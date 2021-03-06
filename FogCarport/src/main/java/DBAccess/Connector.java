package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rasmus2
 */
public class Connector {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://167.99.209.155/fog?useUnicode=yes&characterEncoding=utf-8";
    private String user = "fog";
    private String password = "projectFog:12345";
    private Connection conn = null;

    /**
     * Sets the Connection object used to connect
     *
     * @param con
     */
    public void setConnection(Connection con) {
        conn = con;
    }

    /**
     * Sets address for Connection object
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection connection() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }
}
