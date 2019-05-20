package CarportTest;

import DBAccess.Connector;
import DBAccess.MaterialDBMapper;
import DBAccess.MaterialMapper;
import DBAccess.OrderDBMapper;
import DBAccess.OrderMapper;
import DBAccess.StyklisteDBMapper;
import DBAccess.StyklisteMapper;
import DBAccess.UserDBMapper;
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FogDataTest {

    //Test database connection.
    //private String url = "jdbc:mysql://localhost:3306/databasebasic?UseSSL=false";
    //private String user = "root";
    //private String password = "1234";

    private String url = "jdbc:mysql://167.99.209.155/fogTest?useUnicode=yes&characterEncoding=utf-8";
    private String user = "fogtest";
    private String password = "fogTest123!";

    @Test
    public void testGetMaterialbyID() throws MaterialSampleException, SQLException {
        MaterialDBMapper map = new MaterialDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            Material materialById = map.getMaterialbyID(10);
            String materialName = "hulbånd 1x20 mm. 10 mtr.";
            assertNotNull(materialById);
            assertThat(materialById.getItem_description(), is(materialName));
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void teastGetAllMaterialbyType() throws MaterialSampleException, SQLException {
        MaterialDBMapper map = new MaterialDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            ArrayList<Material> testArr1 = map.getAllMaterialbyType("Træ & Tagplader");
            assertThat(testArr1.get(1).getMaterialType(), is("Træ & Tagplader"));

            ArrayList<Material> testArr2 = map.getAllMaterialbyType("Beslag & Skruer");
            assertThat(testArr2.get(2).getMaterialType(), is("Beslag & Skruer"));

            ArrayList<Material> testArr3 = map.getAllMaterialbyType("Tagpakken");
            assertThat(testArr3.get(3).getMaterialType(), is("Tagpakken"));

        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void testAddNewMaterial() throws MaterialSampleException, SQLException {
        MaterialDBMapper map = new MaterialDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            map.addNewMaterial("TestMaterial", 0.0f, 0.0f, "testEntity", "tesType", 0f, 1);
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void testGetAllMaterials() throws MaterialSampleException, SQLException {
        MaterialDBMapper map = new MaterialDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            ArrayList<Material> testArr = map.getAllMaterials();
            assertNotNull(testArr);
            assertThat(testArr.get(7).getItem_description(), is("97x97 mm. trykimp. Stolpe"));
            assertThat(testArr.get(8).getItem_description(), is("19x100 mm. trykimp. Brædt"));
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void testUpdateMaterialData() throws MaterialSampleException, ClassNotFoundException, SQLException {
        MaterialDBMapper map = new MaterialDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        int testMaterialId = 0;
        try {
            ArrayList<Material> testArr = map.getAllMaterials();
            for (Material mats : testArr) {
                if (mats.getItem_description().equals("TestMaterial")) {
                    testMaterialId = mats.getItem_id();
                }
            }
            map.updateMaterialData(testMaterialId, "TestMaterial", 0.0f, 0.0f, "testEntity", "changed!", 0f, 1);
            Material changedMaterialById = map.getMaterialbyID(testMaterialId);
            String changedMaterialName = "changed!";
            assertNotNull(changedMaterialById);
            assertThat(changedMaterialById.getMaterialType(), is(changedMaterialName));
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void teatDeleteMaterial() throws MaterialSampleException, SQLException {
        MaterialDBMapper map = new MaterialDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        int testMaterialId = 0;
        try {
            ArrayList<Material> testArr = map.getAllMaterials();
            for (Material mats : testArr) {
                if (mats.getItem_description().equals("TestMaterial")) {
                    testMaterialId = mats.getItem_id();
                }
            }
            map.deleteMaterial(testMaterialId);
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void testSaveOrder() throws OrderSampleException, SQLException {
        OrderDBMapper map = new OrderDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            Order testOrder = new Order(1, 6000, 7800, 2300, 0, 3333, 2100);
            assertNotNull(testOrder);
            User usertest = new User("Test", 7, "TestUser");
            testOrder.setUser(usertest);
            assertNotNull(testOrder.getUser());
            map.saveOrder(testOrder);
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testGetAllOrders() throws OrderSampleException, SQLException {
        OrderDBMapper map = new OrderDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            ArrayList<Order> testOrderArr = map.getAllOrders();
            assertNotNull(testOrderArr);
            assertThat(testOrderArr.get(3).getLength(), is(7800f));
            assertThat(testOrderArr.get(4).getLength(), is(5000f));
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testSaveLineItemsInDB() throws StyklistException, OrderSampleException, MaterialSampleException, SQLException {
        StyklisteDBMapper map = new StyklisteDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        OrderDBMapper omap = new OrderDBMapper();
        omap.setMapperConnection(DriverManager.getConnection(url, user, password));
        LogicFacade logic = new LogicFacade();
        int testOrderId = 75;
        try {
            Order orderById = omap.getOrderFromId(testOrderId);
            assertNotNull(orderById);
            Stykliste styk = logic.carportAlgorithm(orderById.getWidth(), orderById.getLength(), orderById.getRoofTilt(), orderById.getShedWidth(), orderById.getShedLength(), 1);
            assertNotNull(styk);
            map.saveLineItemsInDB(styk, testOrderId);
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    /*
    @Test
    public void testAddStyklistToOrder() throws OrderSampleException, MaterialSampleException, SQLException {
        OrderDBMapper omap = new OrderDBMapper();
        omap.setMapperConnection(DriverManager.getConnection(url, user, password));
        LogicFacade logic = new LogicFacade();
        try {
            Order orderById = omap.getOrderFromId(testOrderId);
            assertNotNull(orderById);
            Stykliste styk = logic.carportAlgorithm(orderById.getWidth(), orderById.getLength(), orderById.getRoofTilt(), orderById.getShedWidth(), orderById.getShedLength(), 1);
            orderById.setStyklist(styk);
            assertNotNull(orderById.getStyklist());
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }
     */
    @Test
    public void testGetOrderFromId() throws OrderSampleException, SQLException {
        OrderDBMapper map = new OrderDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        int testOrderId = 73;
        try {
            Order orderById = map.getOrderFromId(testOrderId);
            float orderLength = 7300;
            assertNotNull(orderById);
            assertThat(orderById.getLength(), is(orderLength));
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testEditLineItemsFromOrderID() throws OrderSampleException, SQLException, StyklistException {
        OrderDBMapper omap = new OrderDBMapper();
        omap.setMapperConnection(DriverManager.getConnection(url, user, password));
        StyklisteDBMapper map = new StyklisteDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        int testOrderId = 79;
        int testItem = 4;
        try {
            Stykliste styk = omap.getStyklistForOrder(testOrderId);
            assertNotNull(styk);
            int testLineitem = styk.getStyklist().get(testItem).getLineItemID();
            map.editLineItemsFromOrderID(testLineitem, "testDescription", 8.0f, 8.0f, "testEntity", "testMaterialtype", 10.0f, 24, testOrderId);
            Material lineMat = map.getMaterialFromLineItems(testLineitem);
            assertThat(lineMat.getItem_description(), is("testDescription"));
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testGetMaterialFromLineItems() throws StyklistException, SQLException, OrderSampleException {
        OrderDBMapper omap = new OrderDBMapper();
        omap.setMapperConnection(DriverManager.getConnection(url, user, password));
        StyklisteDBMapper map = new StyklisteDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        int testOrderId = 75;
        int testItem = 7;
        try {
            Stykliste styk = omap.getStyklistForOrder(testOrderId);
            assertNotNull(styk);
            int testLineitem = styk.getStyklist().get(testItem).getLineItemID();
            Material lineMat = map.getMaterialFromLineItems(testLineitem);
            assertNotNull(lineMat);
            assertThat(lineMat.getItem_description(), is("universal 190 mm venstre"));
        } catch (StyklistException se) {
            se.printStackTrace();
        }
    }

    @Test
    public void testGetStyklistFromOrder() throws OrderSampleException, SQLException {
        OrderDBMapper map = new OrderDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        int testOrderId = 75;
        try {
            Stykliste styk = map.getStyklistForOrder(testOrderId);
            assertNotNull(styk);
            assertThat(styk.getStyklist().get(3).getItem_description(), is("bræddebolt 10 x 120 mm."));
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testFinalizeOrder() throws OrderSampleException, SQLException {
        OrderDBMapper map = new OrderDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        int testOrderId = 80;
        try {
            Order orderById = map.getOrderFromId(testOrderId);
            map.unFinalizeOrder(testOrderId);
            assertFalse(orderById.isOrderStatus());
            map.finalizeOrder(testOrderId);
            Order orderByIdfinalized = map.getOrderFromId(testOrderId);
            assertTrue(orderByIdfinalized.isOrderStatus());
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testDeleteOrder() throws OrderSampleException, SQLException {
        OrderDBMapper map = new OrderDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        int testOrderId = 0;
        try {
            ArrayList<Order> testOrderArr = map.getAllOrders();
            assertNotNull(testOrderArr);
            for (Order orders : testOrderArr) {
                if (orders.getShedWidth() == 3333) {
                    testOrderId = orders.getOrder_id();
                    assertThat(orders.getLength(), is(7800f));
                }
            }
            Order beforeOrderById = map.getOrderFromId(testOrderId);
            assertNotNull(beforeOrderById);
            map.deleteOrder(testOrderId);
            Order afterOrderById = map.getOrderFromId(testOrderId);
            assertNull(afterOrderById);
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testCreateUser() throws LoginSampleException, SQLException {
        UserDBMapper map = new UserDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            User user = new User("Test", 7, "TestUser");
            user.setPassword("password");
            assertNotNull(user);
            map.createUser(user.getEmail(), user.getPassword(), user.getRole());
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

    @Test
    public void testVerifyUser() throws LoginSampleException, SQLException {
        UserDBMapper map = new UserDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            assertTrue(map.verifyUser("Test", "password"));
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

    @Test
    public void testGetUserByEmail() throws LoginSampleException, SQLException {
        UserDBMapper map = new UserDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            User getUser = map.getUserByEmail("Test");
            User newUser = new User("Test", 7, "TestUser");
            assertNotNull(getUser);
            assertNotNull(newUser);
            assertThat(getUser.getId(), is(newUser.getId()));
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

    @Test
    public void testLogin() throws LoginSampleException, SQLException {
        UserDBMapper map = new UserDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            User user = map.login("Test", "password");
            assertNotNull(user);
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

    @Test
    public void testRemoveUser() throws LoginSampleException, SQLException {
        UserDBMapper map = new UserDBMapper();
        map.setMapperConnection(DriverManager.getConnection(url, user, password));
        try {
            User beforeUser = map.getUserByEmail("Test");
            assertNotNull(beforeUser);
            map.removeUser(beforeUser);
            User afterUser = map.getUserByEmail("Test");
            assertNull(afterUser);
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

}
