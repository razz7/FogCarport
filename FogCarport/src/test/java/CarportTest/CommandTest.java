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
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rasmu
 */
public class CommandTest {

    private String url = "jdbc:mysql://167.99.209.155/fog?useUnicode=yes&characterEncoding=utf-8";
    private String user = "fog";
    private String password = "projectFog:12345";

    /*
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    @Before
    public void setUp1() throws SQLException {
        Connector con = new Connector();
        Connection conn = DriverManager.getConnection(url, user, password);
        con.setConnection(conn);

    @Before
    public void setUp2() {
    MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPriceCommand() {
    when(request.getParameter("code")).thenReturn("XYZ11");
            //doNothing().when(request).setAttribute(any(String.class), any(Double.class));
            doAnswer(
                    invocation -> {
                        String key = invocation.getArgument(0);
                        double price = invocation.getArgument(1);
                        assertThat(price, is(47.11));
                        return null;
                    }
            ).when(request).setAttribute(any(String.class), any(Double.class));
            when(logic.getPrice("XYZ11")).thenReturn(47.11);
            Command command = new PriceCommand();
            String target = command.execute(request, logic);
            assertThat(target, is("pricepage.jsp"));
        }

    }
*/
}
