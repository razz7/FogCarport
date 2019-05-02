package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://167.99.209.155/fog?useUnicode=yes&characterEncoding=utf-8";
    private String user = "fog";
    private String password = "projectFog:12345";
    private Connection conn = null;

    public void setConnection(Connection con) {
        conn = con;
    }

    public Connection connection() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                
//            String SQL = "SET client_encoding = 'UTF8';";
//            PreparedStatement ps = conn.prepareStatement(SQL);
//            ResultSet rs = ps.executeQuery();
            
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return conn;
    }
}
