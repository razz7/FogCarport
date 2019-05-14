//package CarportTest;
//
//import DBAccess.Connector;
//import DBAccess.MaterialDBMapper;
//import DBAccess.MaterialMapper;
//import DBAccess.OrderDBMapper;
//import DBAccess.OrderMapper;
//import DBAccess.StyklisteMapper;
//import DBAccess.StyklisteDBMapper;
//import DBAccess.UserMapper;
//import FunctionLayer.LogicFacade;
//import FunctionLayer.LoginSampleException;
//import FunctionLayer.Material;
//import FunctionLayer.MaterialSampleException;
//import FunctionLayer.Order;
//import FunctionLayer.OrderSampleException;
//import FunctionLayer.StyklistException;
//import FunctionLayer.Stykliste;
//import FunctionLayer.User;
//import java.rmi.AccessException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import static org.hamcrest.CoreMatchers.any;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import org.junit.Before;
////import org.mockito.Mock;
////import static org.mockito.Mockito.when;
////import org.mockito.MockitoAnnotations;
//
///**
// *
// * @author Rasmus2
// */
//public class FogDataTest {
//
//    private String url = "jdbc:mysql://167.99.209.155/fog?useUnicode=yes&characterEncoding=utf-8";
//    private String user = "fog";
//    private String password = "projectFog:12345";
//
//    // Fields for adding and removing materials and orders to share between unit tests.
//    private int testMaterialId;
//    private int testOrderId;
//    private int testLineitem;
//
//    @Before
//    public void setUp1() throws SQLException {
//        Connector con = new Connector();
//        Connection conn = DriverManager.getConnection(url, user, password);
//        con.setConnection(conn);
//    }
//
//    /*
//    @Before
//    public void setUp2() {
//        MockitoAnnotations.initMocks(this);
//    }
//     */
//    
//    @Test
//    public void testGetMaterialbyID() throws MaterialSampleException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        try {
//            Material materialById = map.getMaterialbyID(10);
//            String materialName = "hulbånd 1x20 mm. 10 mtr.";
//            assertNotNull(materialById);
//            assertThat(materialById.getItem_description(), is(materialName));
//        } catch (MaterialSampleException me) {
//            fail("Caught a mertialsException");
//        }
//    }
//
//    @Test
//    public void teastGetAllMaterialbyType() throws MaterialSampleException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        try {
//            ArrayList<Material> testArr1 = map.getAllMaterialbyType("Træ & Tagplader");
//            assertThat(testArr1.get(1).getMaterialType(), is("Træ & Tagplader"));
//
//            ArrayList<Material> testArr2 = map.getAllMaterialbyType("Beslag & Skruer");
//            assertThat(testArr2.get(2).getMaterialType(), is("Beslag & Skruer"));
//
//            ArrayList<Material> testArr3 = map.getAllMaterialbyType("Tagpakken");
//            assertThat(testArr3.get(3).getMaterialType(), is("Tagpakken"));
//
//        } catch (MaterialSampleException me) {
//            fail("Caught a mertialsException");
//        }
//    }
//
//    @Test
//    public void testAddNewMaterial() throws MaterialSampleException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        try {
//            map.addNewMaterial("TestMaterial", 0.0f, 0.0f, "testEntity", "tesType", 0f, 1);
//        } catch (MaterialSampleException me) {
//            fail("Caught a mertialsException");
//        }
//    }
//
//    @Test
//    public void testGetAllMaterials() throws MaterialSampleException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        try {
//            ArrayList<Material> testArr = map.getAllMaterials();
//            for (Material mats : testArr) {
//                if (mats.getItem_description().equals("TestMaterial")) {
//                    testMaterialId = mats.getItem_id();
//                }
//            }
//        } catch (MaterialSampleException me) {
//            fail("Caught a mertialsException");
//        }
//    }
//
//    @Test
//    public void testUpdateMaterialData() throws MaterialSampleException, ClassNotFoundException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        try {
//            map.updateMaterialData(testMaterialId, "TestMaterial", 0.0f, 0.0f, "testEntity", "changed!", 0f, 1);
//
//            Material changedMaterialById = map.getMaterialbyID(testMaterialId);
//            String changedMaterialName = "changed!";
//            assertNotNull(changedMaterialById);
//            assertThat(changedMaterialById.getMaterialType(), is(changedMaterialName));
//        } catch (MaterialSampleException me) {
//            fail("Caught a mertialsException");
//        }
//    }
//
//    @Test
//    public void teatDeleteMaterial() throws MaterialSampleException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        try {
//            map.deleteMaterial(testMaterialId);
//        } catch (MaterialSampleException me) {
//            fail("Caught a mertialsException");
//        }
//    }
//
//    @Test
//    public void testGetOrderFromId() throws OrderSampleException {
//        OrderDBMapper omap = new OrderDBMapper();
//        try {
//            Order orderById = omap.getOrderFromId(23);
//            float orderLength = 7800;
//            assertNotNull(orderById);
//            assertNotNull(orderById.getStyklist());
//            assertThat(orderById.getLength(), is(orderLength));
//        } catch (OrderSampleException oe) {
//            fail("Caught a OrderSampleException");
//        }
//    }
//
//    @Test
//    public void testSaveOrder() throws OrderSampleException {
//        OrderDBMapper map = new OrderDBMapper();
//        try {
//            Order testOrder = new Order(1, 6000, 7800, 2300, 0, 3333, 2100);
//            map.saveOrder(testOrder);
//        } catch (OrderSampleException oe) {
//            fail("Caught a OrderSampleException");
//        }
//    }
//
//    @Test
//    public void testGetAllOrders() throws OrderSampleException {
//        OrderDBMapper map = new OrderDBMapper();
//        try {
//            ArrayList<Order> testOrderArr = map.getAllOrders();
//            for (Order orders : testOrderArr) {
//                if (orders.getShedWidth() == 3333) {
//                    testOrderId = orders.getOrder_id();
//                }
//            }
//        } catch (OrderSampleException oe) {
//            fail("Caught a OrderSampleException");
//        }
//    }
//
//    /*
//    @Test
//    public void testAddStyklistToOrder() throws OrderSampleException, MaterialSampleException {
//        OrderMapper omap = new OrderMapper();
//        LogicFacade logic = new LogicFacade();
//        try {
//            Order orderById = omap.getOrderFromId(testOrderId);
//            assertNotNull(orderById);
//            Stykliste styk = logic.carportAlgorithm(orderById.getWidth(), orderById.getLength(), orderById.getRoofTilt(), orderById.getShedWidth(), orderById.getShedLength(), 1);
//            orderById.setStyklist(styk);
//            assertNotNull(orderById.getStyklist());
//        } catch (OrderSampleException oe) {
//            fail("Caught a OrderSampleException");
//        } catch (MaterialSampleException me) {
//            fail("Caught a MaterialSampleException");
//        }
//    }
//     */
//    @Test
//    public void testSaveLineItemsInDB() throws OrderSampleException, MaterialSampleException {
//        StyklisteDBMapper map = new StyklisteDBMapper();
//        OrderDBMapper omap = new OrderDBMapper();
//        LogicFacade logic = new LogicFacade();
//        try {
//            Order orderById = omap.getOrderFromId(testOrderId);
//            assertNotNull(orderById);
//            Stykliste styk = logic.carportAlgorithm(orderById.getWidth(), orderById.getLength(), orderById.getRoofTilt(), orderById.getShedWidth(), orderById.getShedLength(), 1);
//            assertNotNull(styk);
//            map.saveLineItemsInDB(styk, testOrderId);
//        } catch (OrderSampleException oe) {
//            fail("Caught a OrderSampleException");
//        } catch (MaterialSampleException me) {
//            fail("Caught a MaterialSampleException");
//        }
//    }
//
//    @Test
//    public void testEditLineItemsFromOrderID() throws OrderSampleException {
//        OrderDBMapper omap = new OrderDBMapper();
//        StyklisteDBMapper map = new StyklisteDBMapper();
//        try {
//            Order orderById = omap.getOrderFromId(testOrderId);
//            assertNotNull(orderById);
//            assertNotNull(orderById.getStyklist());
//            testLineitem = orderById.getStyklist().getStyklist().get(3).getLineItemID();
//            map.editLineItemsFromOrderID(testLineitem, "testDescription2", 8.0f, 8.0f, "testEntity", "testMaterialtype", 10.0f, 24, testOrderId);
//        } catch (OrderSampleException oe) {
//            fail("Caught a OrderSampleException");
//        }
//    }
//
//    @Test
//    public void testGetMaterialFromLineItems() throws StyklistException {
//        StyklisteDBMapper map = new StyklisteDBMapper();
//        try {
//            Material lineMat = map.getMaterialFromLineItems(testLineitem);
//            assertNotNull(lineMat);
//            assertThat(lineMat.getItem_description(), is("testDescription2"));
//        } catch (StyklistException se) {
//            fail("Caught a StyklistException");
//        }
//    }
//
//    @Test
//    public void testGetStyklistFromOrder() throws OrderSampleException {
//        OrderDBMapper map = new OrderDBMapper();
//        try {
//            Stykliste styk = map.getStyklistForOrder(testOrderId);
//            assertNotNull(styk);
//            assertThat(styk.getStyklist().get(3).getItem_description(), is("testDescription2"));
//        } catch (OrderSampleException oe) {
//            fail("Caught a OrderSampleException");
//        }
//    }
//
//    @Test
//    public void testFinalizeOrder() throws OrderSampleException {
//        OrderDBMapper omap = new OrderDBMapper();
//        try {
//            Order orderById = omap.getOrderFromId(testOrderId);
//            assertFalse(orderById.isOrderStatus());
//            omap.finalizeOrder(testOrderId);
//            assertTrue(orderById.isOrderStatus());
//        } catch (OrderSampleException oe) {
//            fail("Caught a OrderSampleException");
//        }
//    }
//
//    /*
//    @Test
//    public void createUser(User user) throws LoginSampleException {
//        UserMapper map = new UserMapper();
//        map.createUser(user);
//    }
//
//    @Test
//    public boolean verifyUser(String email, String password) throws LoginSampleException {
//        UserMapper map = new UserMapper();
//        return map.verifyUser(email, password);
//    }
//
//    @Test
//    public User getUserByEmail(String email) throws LoginSampleException {
//        UserMapper map = new UserMapper();
//        return map.getUserByEmail(email);
//    }
//     */
//}
