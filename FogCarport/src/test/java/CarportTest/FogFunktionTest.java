package CarportTest;

import DBAccess.Connector;
import DBAccess.MaterialMapper;
import DBAccess.OrderMapper;
import DBAccess.StyklisteMapper;
import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.rmi.AccessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.any;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
//import org.mockito.Mock;
//import static org.mockito.Mockito.when;
//import org.mockito.MockitoAnnotations;

/**
 *
 * @author Rasmus2
 */
public class FogFunktionTest {
    /*

    private String url = "jdbc:mysql://167.99.209.155/fog?useUnicode=yes&characterEncoding=utf-8";
    private String user = "fog";
    private String password = "projectFog:1234_5";

    // Fields for adding and removing materials and orders to share between unit tests.
    

    @Before
    public void setUp1() throws SQLException {
        Connector con = new Connector();
        Connection conn = DriverManager.getConnection(url, user, password);
        con.setConnection(conn);
    }
*/
    /*
    @Before
    public void setUp2() {
        MockitoAnnotations.initMocks(this);
    }
     */
 /*
    @Test
    public FunctionLayer.Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
        CarportAlgorithm car = new CarportAlgorithm();
        return car.carportAlgorithm(width, length, roofTilt, shedwidth, shedLength, styklist_id);
    }

    @Test
    public FunctionLayer.Material Material(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int versionnr) {
        Material mat = new Material(item_id, item_description, width, height, entity, materialtype, price, versionnr);
        return mat;
    }

    @Test
    public FunctionLayer.Order Order(int order_id, float width, float length, float height, float roofTilt, float shedWidth, float shedLength) {
        Order order = new Order(order_id, width, length, height, roofTilt, shedWidth, shedLength);
        return order;
    }

    @Test
    public FunctionLayer.Stykliste Stykliste(ArrayList<FunctionLayer.Material> styklist, int styklist_id) {
        Stykliste styk = new Stykliste(styklist, styklist_id);
        return styk;
    }

    @Test
    public String getSalt(int length) {
        Encryption enc = new Encryption();
        return enc.getSalt(length);
    }

    @Test
    public String generateSecurePassword(String password, String salt) {
        Encryption enc = new Encryption();
        return enc.generateSecurePassword(password, salt);
    }

    @Test
    public boolean verifyUserPassword(String providedPassword, String securepassword, String salt) {
        Encryption enc = new Encryption();
        return enc.verifyUserPassword(providedPassword, securepassword, salt);
    }

    @Test
    public FunctionLayer.User User(String email, int id, String role) {
        User user = new User(email, id, role);
        return user;
    }
     */
}
