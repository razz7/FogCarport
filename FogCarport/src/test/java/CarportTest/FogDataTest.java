package CarportTest;

import DBAccess.MaterialDBMapper;
import DBAccess.OrderDBMapper;
import DBAccess.StyklisteDBMapper;
import DBAccess.UserDBMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;

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

    private MaterialDBMapper matMap;
    private OrderDBMapper ordMap;
    private StyklisteDBMapper styMap;
    private UserDBMapper useMap;

    @Before
    public void setUp() throws SQLException {
        matMap = new MaterialDBMapper();
        matMap.setMapperConnection(DriverManager.getConnection(url, user, password));

        ordMap = new OrderDBMapper();
        ordMap.setMapperConnection(DriverManager.getConnection(url, user, password));

        styMap = new StyklisteDBMapper();
        styMap.setMapperConnection(DriverManager.getConnection(url, user, password));

        useMap = new UserDBMapper();
        useMap.setMapperConnection(DriverManager.getConnection(url, user, password));
    }

    @Test
    public void testGetMaterialbyID() throws MaterialSampleException, SQLException {
        try {
            Material materialById = matMap.getMaterialbyID(10);
            String materialName = "hulbånd 1x20 mm. 10 mtr.";
            assertNotNull(materialById);
            assertThat(materialById.getItem_description(), is(materialName));
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void teastGetAllMaterialbyType() throws MaterialSampleException, SQLException {
        try {
            ArrayList<Material> testArr1 = matMap.getAllMaterialbyType("Træ & Tagplader");
            assertThat(testArr1.get(1).getMaterialType(), is("Træ & Tagplader"));

            ArrayList<Material> testArr2 = matMap.getAllMaterialbyType("Beslag & Skruer");
            assertThat(testArr2.get(2).getMaterialType(), is("Beslag & Skruer"));

            ArrayList<Material> testArr3 = matMap.getAllMaterialbyType("Tagpakken");
            assertThat(testArr3.get(3).getMaterialType(), is("Tagpakken"));

        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void testAddNewMaterial() throws MaterialSampleException, SQLException {
        try {
            matMap.addNewMaterial("TestMaterial", 0.0f, 0.0f, "testEntity", "tesType", 0f, 1);
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void testGetAllMaterials() throws MaterialSampleException, SQLException {
        try {
            ArrayList<Material> testArr = matMap.getAllMaterials();
            assertNotNull(testArr);
            assertThat(testArr.get(7).getItem_description(), is("97x97 mm. trykimp. Stolpe"));
            assertThat(testArr.get(8).getItem_description(), is("19x100 mm. trykimp. Brædt"));
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void testUpdateMaterialData() throws MaterialSampleException, ClassNotFoundException, SQLException {
        int testMaterialId = 0;
        try {
            ArrayList<Material> testArr = matMap.getAllMaterials();
            for (Material mats : testArr) {
                if (mats.getItem_description().equals("TestMaterial")) {
                    testMaterialId = mats.getItem_id();
                }
            }
            matMap.updateMaterialData(testMaterialId, "TestMaterial", 0.0f, 0.0f, "testEntity", "changed!", 0f, 1);
            Material changedMaterialById = matMap.getMaterialbyID(testMaterialId);
            String changedMaterialName = "changed!";
            assertNotNull(changedMaterialById);
            assertThat(changedMaterialById.getMaterialType(), is(changedMaterialName));
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void teatDeleteMaterial() throws MaterialSampleException, SQLException {
        int testMaterialId = 0;
        try {
            ArrayList<Material> testArr = matMap.getAllMaterials();
            for (Material mats : testArr) {
                if (mats.getItem_description().equals("TestMaterial")) {
                    testMaterialId = mats.getItem_id();
                }
            }
            matMap.deleteMaterial(testMaterialId);
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    @Test
    public void testSaveOrder() throws OrderSampleException, SQLException {
        try {
            Order testOrder = new Order(1, 6000, 7800, 2300, 0, 3333, 2100);
            assertNotNull(testOrder);
            User usertest = new User("Test", 7, "TestUser");
            testOrder.setUser(usertest);
            assertNotNull(testOrder.getUser());
            ordMap.saveOrder(testOrder);
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testGetAllOrders() throws OrderSampleException, SQLException {
        try {
            ArrayList<Order> testOrderArr = ordMap.getAllOrders();
            assertNotNull(testOrderArr);
            assertThat(testOrderArr.get(3).getLength(), is(7800f));
            assertThat(testOrderArr.get(4).getLength(), is(5000f));
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testSaveLineItemsInDB() throws StyklistException, OrderSampleException, MaterialSampleException, SQLException {
        LogicFacade logic = new LogicFacade();
        int testOrderId = 75;
        try {
            Order orderById = ordMap.getOrderFromId(testOrderId);
            assertNotNull(orderById);
            Stykliste styk = logic.carportAlgorithm(orderById.getWidth(), orderById.getLength(), orderById.getRoofTilt(), orderById.getShedWidth(), orderById.getShedLength(), 1);
            assertNotNull(styk);
            styMap.saveLineItemsInDB(styk, testOrderId);
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }

    /*
    @Test
    public void testAddStyklistToOrder() throws OrderSampleException, MaterialSampleException, SQLException {
        LogicFacade logic = new LogicFacade();
        try {
            Order orderById = ordMap.getOrderFromId(75);
            assertNotNull(orderById);
            Stykliste styk = logic.carportAlgorithm(orderById.getWidth(), orderById.getLength(), orderById.getRoofTilt(), orderById.getShedWidth(), orderById.getShedLength(), 1);
            orderById.setStyklist(styk);
            assertNotNull(orderById.getStyklist());
        } catch (MaterialSampleException me) {
            me.printStackTrace();
        }
    }
     */
    @Test
    public void testGetOrderFromId() throws OrderSampleException, SQLException {
        int testOrderId = 73;
        try {
            Order orderById = ordMap.getOrderFromId(testOrderId);
            float orderLength = 7300;
            assertNotNull(orderById);
            assertThat(orderById.getLength(), is(orderLength));
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testEditLineItemsFromOrderID() throws OrderSampleException, SQLException, StyklistException {
        int testOrderId = 79;
        int testItem = 4;
        try {
            Stykliste styk = ordMap.getStyklistForOrder(testOrderId);
            assertNotNull(styk);
            int testLineitem = styk.getStyklist().get(testItem).getLineItemID();
            styMap.editLineItemsFromOrderID(testLineitem, "testDescription", 8.0f, 8.0f, "testEntity", "testMaterialtype", 10.0f, 24, testOrderId);
            Material lineMat = styMap.getMaterialFromLineItems(testLineitem);
            assertThat(lineMat.getItem_description(), is("testDescription"));
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testGetMaterialFromLineItems() throws StyklistException, SQLException, OrderSampleException {
        int testOrderId = 75;
        int testItem = 7;
        try {
            Stykliste styk = ordMap.getStyklistForOrder(testOrderId);
            assertNotNull(styk);
            int testLineitem = styk.getStyklist().get(testItem).getLineItemID();
            Material lineMat = styMap.getMaterialFromLineItems(testLineitem);
            assertNotNull(lineMat);
            assertThat(lineMat.getItem_description(), is("universal 190 mm venstre"));
        } catch (StyklistException se) {
            se.printStackTrace();
        }
    }

    @Test
    public void testGetStyklistFromOrder() throws OrderSampleException, SQLException {
        int testOrderId = 75;
        try {
            Stykliste styk = ordMap.getStyklistForOrder(testOrderId);
            assertNotNull(styk);
            assertThat(styk.getStyklist().get(3).getItem_description(), is("bræddebolt 10 x 120 mm."));
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testFinalizeOrder() throws OrderSampleException, SQLException {
        int testOrderId = 80;
        try {
            Order orderById = ordMap.getOrderFromId(testOrderId);
            ordMap.unFinalizeOrder(testOrderId);
            assertFalse(orderById.isOrderStatus());
            ordMap.finalizeOrder(testOrderId);
            Order orderByIdfinalized = ordMap.getOrderFromId(testOrderId);
            assertTrue(orderByIdfinalized.isOrderStatus());
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testDeleteOrder() throws OrderSampleException, SQLException {
        int testOrderId = 0;
        try {
            ArrayList<Order> testOrderArr = ordMap.getAllOrders();
            assertNotNull(testOrderArr);
            for (Order orders : testOrderArr) {
                if (orders.getShedWidth() == 3333) {
                    testOrderId = orders.getOrder_id();
                    assertThat(orders.getLength(), is(7800f));
                }
            }
            Order beforeOrderById = ordMap.getOrderFromId(testOrderId);
            assertNotNull(beforeOrderById);
            ordMap.deleteOrder(testOrderId);
            Order afterOrderById = ordMap.getOrderFromId(testOrderId);
            assertNull(afterOrderById);
        } catch (OrderSampleException oe) {
            oe.printStackTrace();
        }
    }

    @Test
    public void testCreateUser() throws LoginSampleException, SQLException {
        try {
            User user = new User("Test", 7, "TestUser");
            user.setPassword("password");
            assertNotNull(user);
            useMap.createUser(user.getEmail(), user.getPassword(), user.getRole());
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

    @Test
    public void testVerifyUser() throws LoginSampleException, SQLException {
        try {
            assertTrue(useMap.verifyUser("Test", "password"));
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

    @Test
    public void testGetUserByEmail() throws LoginSampleException, SQLException {
        try {
            User getUser = useMap.getUserByEmail("Test");
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
        try {
            User user = useMap.login("Test", "password");
            assertNotNull(user);
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

    @Test
    public void testRemoveUser() throws LoginSampleException, SQLException {
        try {
            User beforeUser = useMap.getUserByEmail("Test");
            assertNotNull(beforeUser);
            useMap.removeUser(beforeUser);
            User afterUser = useMap.getUserByEmail("Test");
            assertNull(afterUser);
        } catch (LoginSampleException le) {
            le.printStackTrace();
        }
    }

}