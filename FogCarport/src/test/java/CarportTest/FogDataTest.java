//package CarportTest;
//
//import DBAccess.Connector;
//import DBAccess.MaterialDBMapper;
//import DBAccess.MaterialMapper;
//import DBAccess.OrderDBMapper;
//import DBAccess.OrderMapper;
//import DBAccess.StyklisteDBMapper;
//import DBAccess.StyklisteMapper;
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
//import java.sql.PreparedStatement;
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
//    //Test database connection.
//    private String url = "jdbc:mysql://localhost:3306/databasebasic?UseSSL=false";
//    private String user = "root";
//    private String password = "1234";
//
//    //private String url = "jdbc:mysql://167.99.209.155/fogTest?useUnicode=yes&characterEncoding=utf-8";
//    //private String user = "fogtest";
//    //private String password = "fogTest123!";
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
//        /*
//        try {
////            String url = "jdbc:mysql://167.99.209.155/";
////            String user = "fogtest";
////            String password = "fogTest123!";
////            
////        Connector con = new Connector();
////        Connection conn = DriverManager.getConnection(url, user, password);
////        con.setConnection(conn);
//
//            String dropSchema = "DROP SCHEMA IF exists `fogTest`;";
//            String createSchema = "CREATE SCHEMA IF NOT EXISTS `fogTest`";
//            String useFogTest = "USE `fogTest`;";
//            String createTableStock = "CREATE TABLE `fogTest`.`stock`("
//                    + "`item_id` int(11) NOT NULL AUTO_INCREMENT,"
//                    + "`item_description` text,"
//                    + "`width` float DEFAULT NULL,"
//                    + "`height` float DEFAULT NULL,"
//                    + "`entity` text,"
//                    + "`materialtype` text,"
//                    + "`price` float DEFAULT '0',"
//                    + "`stockquantity` int(11) DEFAULT '0',"
//                    + "PRIMARY KEY (`item_id`));";
//
//            String insertIntoStock = "INSERT INTO `stock`(`item_id`, `item_description`, `width`, `height`, `entity`, `materialtype`, `price`, `stockquantity`) VALUES"
//                    + "(1,'25x200 mm. trykimp. Brædt',25,200,'stk','Træ & Tagplader',0,0),"
//                    + "(2,'25x125mm. trykimp. Brædt.',25,125,'stk','Træ & Tagplader',0,0),"
//                    + "(3,'38x73 mm. Lægte ubh.',38,73,'stk','Træ & Tagplader',0,0),"
//                    + "(4,'45x95 mm. Reglar ub.',45,95,'stk','Træ & Tagplader',0,0),"
//                    + "(5,'45x195 mm. spærtræ ubh.',45,195,'stk','Træ & Tagplader',0,0),"
//                    + "(6,'97x97 mm. trykimp. Stolpe',97,97,'stk','Træ & Tagplader',0,0),"
//                    + "(7,'19x100 mm. trykimp. Brædt',19,100,'stk','Træ & Tagplader',0,0),"
//                    + "(8,'Plastmo Ecolite blåtonet',0,0,'stk','Træ & Tagplader',0,0),"
//                    + "(9,'plastmo bundskruer 200 stk.',0,0,'pakke','Beslag & Skruer',0,0),"
//                    + "(10,'hulbånd 1x20 mm. 10 mtr.',1,20,'rulle','Beslag & Skruer',0,0),"
//                    + "(12,'universal 190 mm højre',0,190,'stk','Beslag & Skruer',0,0),"
//                    + "(13,'universal 190 mm venstre',0,190,'stk','Beslag & Skruer',0,0),"
//                    + "(14,'4,5 x 60 mm. skruer 200 stk.',4.5,60,'pakke','Beslag & Skruer',0,0),"
//                    + "(15,'4,0 x 50 mm. beslagskruer 250 stk.',4,50,'pakke','Beslag & Skruer',0,0),"
//                    + "(16,'bræddebolt 10 x 120 mm.',10,120,'stk','Beslag & Skruer',0,0),"
//                    + "(17,'firkantskiver 40x40x11mm',40,40,'stk','Beslag & Skruer',0,0),"
//                    + "(18,'4,5 x 70 mm. Skruer 400 stk.',4.5,70,'pk','Beslag & Skruer',0,0),"
//                    + "(19,'4,5 x 50 mm. Skruer 300 stk.',4.5,50,'pk','Beslag & Skruer',0,0),"
//                    + "(20,'stalddørsgreb 50x75',50,75,'sæt','Beslag & Skruer',0,0),"
//                    + "(21,'t hængsel 390 mm',0,0,'stk','Beslag & Skruer',0,0),"
//                    + "(22,'vinkelbeslag 35',0,0,'stk','Beslag & Skruer',0,0),"
//                    + "(23,'25x150 mm. trykimp. Bræt',25,150,'stk','Træ',0,0),"
//                    + "(24,'fædigskåret (byg-selv spær)',0,0,'sæt','Træ',0,0),"
//                    + "(25,'25x50 mm. trykimp. Bræt',25,50,'stk','Træ',0,0),"
//                    + "(26,'38x73 mm. taglægte T1',38,73,'stk','Træ',0,0),"
//                    + "(27,'B & C Dobbelt -s sort',0,0,'stk','Tagpakken',0,0),"
//                    + "(28,'B & C Rygsten sort',0,0,'stk','Tagpakken',0,0),"
//                    + "(29,'B & C Toplægte holder',0,0,'stk','Tagpakken',0,0),"
//                    + "(30,'B & C rygstensbeslag',0,0,'stk','Tagpakken',0,0),"
//                    + "(31,'B & C tagstens bindere & nakkekroge',0,0,'pk','Tagpakken',0,0),"
//                    + "(32,'5,0 x 40 mm. beslagskruer 250 stk.',5,40,'pakke','Beslag & Skruer',0,0),"
//                    + "(33,'5,0 x 100 mm. skruer 100 stk.',5,100,'pakke','Beslag & Skruer',0,0),"
//                    + "(34,'4,5 x 70 mm. Skruer 200 stk.',4.5,70,'pk','Beslag & Skruer',0,0),"
//                    + "(35,'4,5 x 50 mm. Skruer 350 stk.',4.5,50,'pk','Beslag & Skruer',0,0);";
//
//            String createOrders = "CREATE TABLE IF NOT EXISTS `fogTest`.`orders` ("
//                    + "`order_id` INT(11) NOT NULL AUTO_INCREMENT,"
//                    + "`width` FLOAT NULL DEFAULT NULL,"
//                    + "`length` FLOAT NULL DEFAULT NULL,"
//                    + "`rooftilt` FLOAT NULL DEFAULT NULL,"
//                    + "`shedwidth` FLOAT NULL DEFAULT NULL,"
//                    + "`shedlength` FLOAT NULL DEFAULT NULL,"
//                    + "`status` TINYINT(4) NULL DEFAULT '0',"
//                    + "`customer_id` INT(11) NULL DEFAULT NULL,"
//                    + "`orderdate` DATE NULL DEFAULT NULL,"
//                    + "`customername` VARCHAR(45) NULL DEFAULT NULL,"
//                    + "PRIMARY KEY (`order_id`));";
//
//            String createLineitems = "CREATE TABLE `fogTest`.`lineitems` ("
//                    + "`lineitems_id` INT(11) NOT NULL AUTO_INCREMENT,"
//                    + "`item_id` INT(11) NULL DEFAULT NULL,"
//                    + "`order_id` INT(11) NOT NULL,"
//                    + "foreign key(`order_id`) references orders(`order_id`),"
//                    + "`item_description` TEXT NULL DEFAULT NULL,"
//                    + "`width` FLOAT NULL DEFAULT NULL,"
//                    + "`length`FLOAT NULL DEFAULT NULL,"
//                    + "`height` FLOAT NULL DEFAULT NULL,"
//                    + "`entity` VARCHAR(45) NULL DEFAULT NULL,"
//                    + "`materialtype` VARCHAR(45) NULL DEFAULT NULL,"
//                    + "`price` FLOAT NULL DEFAULT NULL,"
//                    + "`orderquantity` INT(11) NULL DEFAULT NULL,"
//                    + "`versionnr` INT(11) NULL DEFAULT NULL,"
//                    + "PRIMARY KEY (`lineitems_id`, `order_id`),"
//                    + "CONSTRAINT `deleteOrder`"
//                    + "FOREIGN KEY (`order_id`)"
//                    + "REFERENCES `orders` (`order_id`)"
//                    + "ON DELETE CASCADE);";
//
//            String createUsers = "CREATE TABLE IF NOT EXISTS `fogTest`.`users` ("
//                    + "`user_id` INT(11) NOT NULL AUTO_INCREMENT,"
//                    + "`email` VARCHAR(200) NULL DEFAULT NULL,"
//                    + "`role` VARCHAR(45) NULL DEFAULT NULL,"
//                    + "`securepassword` VARCHAR(45) NULL DEFAULT NULL,"
//                    + "`salt` VARCHAR(45) NULL DEFAULT NULL,"
//                    + "PRIMARY KEY (`user_id`))";
//
//            PreparedStatement ps = con.connection().prepareStatement(dropSchema);
//            PreparedStatement ps1 = con.connection().prepareStatement(createSchema);
//            PreparedStatement ps2 = con.connection().prepareStatement(useFogTest);
//            PreparedStatement ps3 = con.connection().prepareStatement(createTableStock);
//            PreparedStatement ps4 = con.connection().prepareStatement(insertIntoStock);
//            PreparedStatement ps5 = con.connection().prepareStatement(createOrders);
//            PreparedStatement ps6 = con.connection().prepareStatement(createLineitems);
//            PreparedStatement ps7 = con.connection().prepareStatement(createUsers);
//
//            ps.executeUpdate();
//            ps1.executeUpdate();
//            ps2.executeUpdate();
//            ps3.executeUpdate();
//            ps4.executeUpdate();
//            ps5.executeUpdate();
//            ps6.executeUpdate();
//            ps7.executeUpdate();
//
//        } catch (SQLException | ClassNotFoundException ex) {
//            throw new SQLException(ex.getMessage());
//        }
//         */
//
//    }
//
//    /*
//    @Before
//    public void setUp2() {
//        MockitoAnnotations.initMocks(this);
//    }
//     */
//    @Test
//    public void testGetMaterialbyID() throws MaterialSampleException, SQLException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            Material materialById = map.getMaterialbyID(10);
//            String materialName = "hulbånd 1x20 mm. 10 mtr.";
//            assertNotNull(materialById);
//            assertThat(materialById.getItem_description(), is(materialName));
//        } catch (MaterialSampleException me) {
//            me.printStackTrace();
//        }
//    }
//
//    @Test
//    public void teastGetAllMaterialbyType() throws MaterialSampleException, SQLException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
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
//            me.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testAddNewMaterial() throws MaterialSampleException, SQLException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            map.addNewMaterial("TestMaterial", 0.0f, 0.0f, "testEntity", "tesType", 0f, 1);
//        } catch (MaterialSampleException me) {
//            me.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testGetAllMaterials() throws MaterialSampleException, SQLException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            ArrayList<Material> testArr = map.getAllMaterials();
//            for (Material mats : testArr) {
//                if (mats.getItem_description().equals("TestMaterial")) {
//                    testMaterialId = mats.getItem_id();
//                }
//            }
//        } catch (MaterialSampleException me) {
//            me.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testUpdateMaterialData() throws MaterialSampleException, ClassNotFoundException, SQLException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            map.updateMaterialData(testMaterialId, "TestMaterial", 0.0f, 0.0f, "testEntity", "changed!", 0f, 1);
//
//            Material changedMaterialById = map.getMaterialbyID(testMaterialId);
//            String changedMaterialName = "changed!";
//            assertNotNull(changedMaterialById);
//            assertThat(changedMaterialById.getMaterialType(), is(changedMaterialName));
//        } catch (MaterialSampleException me) {
//            me.printStackTrace();
//        }
//    }
//
//    @Test
//    public void teatDeleteMaterial() throws MaterialSampleException, SQLException {
//        MaterialDBMapper map = new MaterialDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            map.deleteMaterial(testMaterialId);
//        } catch (MaterialSampleException me) {
//            me.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testGetOrderFromId() throws OrderSampleException, SQLException {
//        OrderDBMapper map = new OrderDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            Order orderById = map.getOrderFromId(23);
//            float orderLength = 7800;
//            assertNotNull(orderById);
//            assertNotNull(orderById.getStyklist());
//            assertThat(orderById.getLength(), is(orderLength));
//        } catch (OrderSampleException oe) {
//            oe.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testSaveOrder() throws OrderSampleException, SQLException {
//        OrderDBMapper map = new OrderDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            Order testOrder = new Order(1, 6000, 7800, 2300, 0, 3333, 2100);
//            User user = new User("test", 9999, "test");
//            testOrder.setUser(user);
//            map.saveOrder(testOrder);
//        } catch (OrderSampleException oe) {
//            oe.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testGetAllOrders() throws OrderSampleException, SQLException {
//        OrderDBMapper map = new OrderDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            ArrayList<Order> testOrderArr = map.getAllOrders();
//            for (Order orders : testOrderArr) {
//                if (orders.getShedWidth() == 3333) {
//                    testOrderId = orders.getOrder_id();
//                }
//            }
//        } catch (OrderSampleException oe) {
//            oe.printStackTrace();
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
//    public void testSaveLineItemsInDB() throws StyklistException, OrderSampleException, MaterialSampleException, SQLException {
//        StyklisteDBMapper map = new StyklisteDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        OrderDBMapper omap = new OrderDBMapper();
//        omap.setMapperConnection(DriverManager.getConnection(url, user, password));
//        LogicFacade logic = new LogicFacade();
//        try {
//            Order orderById = omap.getOrderFromId(testOrderId);
//            assertNotNull(orderById);
//            Stykliste styk = logic.carportAlgorithm(orderById.getWidth(), orderById.getLength(), orderById.getRoofTilt(), orderById.getShedWidth(), orderById.getShedLength(), 1);
//            assertNotNull(styk);
//            map.saveLineItemsInDB(styk, testOrderId);
//        } catch (OrderSampleException oe) {
//            oe.printStackTrace();
//        } catch (MaterialSampleException me) {
//            me.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testEditLineItemsFromOrderID() throws OrderSampleException, SQLException {
//        OrderDBMapper omap = new OrderDBMapper();
//        omap.setMapperConnection(DriverManager.getConnection(url, user, password));
//        StyklisteDBMapper map = new StyklisteDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            Order orderById = omap.getOrderFromId(testOrderId);
//            assertNotNull(orderById);
//            assertNotNull(orderById.getStyklist());
//            testLineitem = orderById.getStyklist().getStyklist().get(3).getLineItemID();
//            map.editLineItemsFromOrderID(testLineitem, "testDescription2", 8.0f, 8.0f, "testEntity", "testMaterialtype", 10.0f, 24, testOrderId);
//        } catch (OrderSampleException oe) {
//            oe.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testGetMaterialFromLineItems() throws StyklistException, SQLException {
//        StyklisteDBMapper map = new StyklisteDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            Material lineMat = map.getMaterialFromLineItems(testLineitem);
//            assertNotNull(lineMat);
//            assertThat(lineMat.getItem_description(), is("testDescription2"));
//        } catch (StyklistException se) {
//            se.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testGetStyklistFromOrder() throws OrderSampleException, SQLException {
//        OrderDBMapper map = new OrderDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            Stykliste styk = map.getStyklistForOrder(testOrderId);
//            assertNotNull(styk);
//            assertThat(styk.getStyklist().get(3).getItem_description(), is("testDescription2"));
//        } catch (OrderSampleException oe) {
//            oe.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testFinalizeOrder() throws OrderSampleException, SQLException {
//        OrderDBMapper map = new OrderDBMapper();
//        map.setMapperConnection(DriverManager.getConnection(url, user, password));
//        try {
//            Order orderById = map.getOrderFromId(testOrderId);
//            assertFalse(orderById.isOrderStatus());
//            map.finalizeOrder(testOrderId);
//            assertTrue(orderById.isOrderStatus());
//        } catch (OrderSampleException oe) {
//            oe.printStackTrace();
//        }
//    }
//    
//}
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
