/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarportTest;

import DBAccess.Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.junit.Before;

/**
 *
 * @author rasmu
 */
public class CommandTest {

    private String url = "jdbc:mysql://167.99.209.155/fog?useUnicode=yes&characterEncoding=utf-8";
    private String user = "fog";
    private String password = "projectFog:12345";

    @Before
    public void setUp1() throws SQLException {
        Connector con = new Connector();
        Connection conn = DriverManager.getConnection(url, user, password);
        con.setConnection(conn);
    }
    @Before
    public void setUp2() {
        HttpServletRequest request;
    }

}
