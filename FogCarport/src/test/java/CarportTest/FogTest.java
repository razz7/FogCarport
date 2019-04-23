package CarportTest;

import DBAccess.Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rasmus2
 */
public class FogTest {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://167.99.209.155/fog";
    private String user = "fog";
    private String password = "projectFog:12345";

    public void FogTestConnection() throws SQLException {
        Connector con = new Connector();
        Connection conn = DriverManager.getConnection(url, user, password);
        con.setConnection(conn);
    }

}
