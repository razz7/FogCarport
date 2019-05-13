package CarportTest;

import DBAccess.Connector;
import DBAccess.MaterialMapper;
import DBAccess.OrderMapper;
import DBAccess.StyklisteMapper;
import DBAccess.UserMapper;
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
public class FogTest {

    private String url = "jdbc:mysql://167.99.209.155/fog?useUnicode=yes&characterEncoding=utf-8";
    private String user = "fog";
    private String password = "projectFog:1234_5";

    // Fields for adding and removing materials and orders to share between unit tests.
    private int testMaterialDescription;

    @Before
    public void setUp1() throws SQLException {
        Connector con = new Connector();
        Connection conn = DriverManager.getConnection(url, user, password);
        con.setConnection(conn);
    }

    @Before
    public void setUp2() {
        //MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMaterialbyID() throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        try {
            Material materialById = map.getMaterialbyID(10);
            String materialName = "hulbånd 1x20 mm. 10 mtr.";
            assertNotNull(materialById);
            assertThat(materialById.getItem_description(), is(materialName));
        } catch (MaterialSampleException me) {
            fail("Caught a mertialsException");
        }
    }

    @Test
    public void teastGetAllMaterialbyType() throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        try {
            ArrayList<Material> testArr1 = map.getAllMaterialbyType("Træ & Tagplader");
            assertThat(testArr1.get(1).getMaterialType(), is("Træ & Tagplader"));

            ArrayList<Material> testArr2 = map.getAllMaterialbyType("Beslag & Skruer");
            assertThat(testArr2.get(2).getMaterialType(), is("Beslag & Skruer"));

            ArrayList<Material> testArr3 = map.getAllMaterialbyType("Tagpakken");
            assertThat(testArr3.get(3).getMaterialType(), is("Tagpakken"));

        } catch (MaterialSampleException me) {
            fail("Caught a mertialsException");
        }
    }

    @Test
    public void testAddNewMaterial() throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        try {
            map.addNewMaterial("TestMaterial", 0.0f, 0.0f, "testEntity", "tesType", 0f, 1);
        } catch (MaterialSampleException me) {
            fail("Caught a mertialsException");
        }
    }

    @Test
    public void testGetAllMaterials() throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        try {
            ArrayList<Material> testArr = map.getAllMaterials();
            for (Material mats : testArr) {
                if (mats.getItem_description().equals("TestMaterial")) {
                    testMaterialDescription = mats.getItem_id();
                }
            }
        } catch (MaterialSampleException me) {
            fail("Caught a mertialsException");
        }
    }

    @Test
    public void testUpdateMaterialData() throws MaterialSampleException, ClassNotFoundException {
        MaterialMapper map = new MaterialMapper();
        try {
            map.updateMaterialData(testMaterialDescription, "TestMaterial", 0.0f, 0.0f, "testEntity", "changed!", 0f, 1);

            Material changedMaterialById = map.getMaterialbyID(testMaterialDescription);
            String changedMaterialName = "changed!";
            assertNotNull(changedMaterialById);
            assertThat(changedMaterialById.getMaterialType(), is(changedMaterialName));
        } catch (MaterialSampleException me) {
            fail("Caught a mertialsException");
        }
    }

    @Test
    public void teatDeleteMaterial() throws MaterialSampleException {
        MaterialMapper map = new MaterialMapper();
        try {
            map.deleteMaterial(testMaterialDescription);
        } catch (MaterialSampleException me) {
            fail("Caught a mertialsException");
        }
    }

    /*

    @Test
    public ArrayList<Order> getAllOrders() throws OrderSampleException {
        OrderMapper map = new OrderMapper();
        return map.getAllOrders();
    }

    @Test
    public Order getOrderFromId(int order_id) throws OrderSampleException {
        OrderMapper map = new OrderMapper();
        return map.getOrderFromId(order_id);
    }

    @Test
    public void saveOrder(Order order) throws OrderSampleException, StyklistException {
        OrderMapper map = new OrderMapper();
        map.saveOrder(order);
    }

    @Test
    public void editLineItemsFromOrderID(int lineitem_id, String item_description, float width, float height, String entity, String materialtype, float price, int orderquantity, int order_id) {
        StyklisteMapper map = new StyklisteMapper();
        map.editLineItemsFromOrderID(lineitem_id, item_description, width, height, entity, materialtype, price, orderquantity, order_id);

    }

    @Test
    public void saveLineItemsInDB(Stykliste styklist, int order_id) throws StyklistException {
        StyklisteMapper map = new StyklisteMapper();
        map.saveLineItemsInDB(styklist, order_id);
    }

    @Test
    public Material getMaterialFromLineItems(int lineItemID) throws StyklistException {
        StyklisteMapper map = new StyklisteMapper();
        return map.getMaterialFromLineItems(lineItemID);
    }

    @Test
    public void finalizeOrder(int order_id) throws OrderSampleException {
        OrderMapper map = new OrderMapper();
        map.finalizeOrder(order_id);
    }

    @Test
    public Stykliste getStyklistForOrder(int order_id) throws OrderSampleException {
        OrderMapper map = new OrderMapper();
        return map.getStyklistForOrder(order_id);
    }

    @Test
    public void createUser(User user) throws LoginSampleException {
        UserMapper map = new UserMapper();
        map.createUser(user);
    }

    @Test
    public boolean verifyUser(String email, String password) throws LoginSampleException {
        UserMapper map = new UserMapper();
        return map.verifyUser(email, password);
    }

    @Test
    public User getUserByEmail(String email) throws LoginSampleException {
        UserMapper map = new UserMapper();
        return map.getUserByEmail(email);
    }
     */
}
