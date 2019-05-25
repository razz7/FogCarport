package CarportTest;

import FunctionLayer.CarportAlgorithm;
import FunctionLayer.Encryption;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author Rasmus2
 */
public class FogFunktionTest {

    @Test
    public void testCarportAlgorithm() throws MaterialSampleException {
        CarportAlgorithm car = new CarportAlgorithm();
        Stykliste styklist = car.carportAlgorithm(6000, 7800, 0, 5300, 2100, 1);
        assertNotNull(styklist);
        assertThat(styklist.getStyklist().get(4).getItem_description(), is("firkantskiver 40x40x11mm"));
        assertThat(styklist.getStyklist().get(4).getStryklistQty(), is(20));
        assertThat(styklist.getStyklist().size(), is(29));

        Stykliste styklist2 = car.carportAlgorithm(6000, 7800, 0, 0, 0, 1);
        assertNotNull(styklist2);
        assertThat(styklist2.getStyklist().get(4).getItem_description(), is("45x195 mm. spærtræ ubh."));
        assertThat(styklist2.getStyklist().get(4).getStryklistQty(), is(14));
        assertThat(styklist2.getStyklist().size(), is(19));

        Stykliste styklist3 = car.carportAlgorithm(6000, 7800, 30, 5300, 2100, 1);
        assertNotNull(styklist3);
        assertThat(styklist3.getStyklist().get(7).getItem_description(), is("universal 190 mm venstre"));
        assertThat(styklist3.getStyklist().get(7).getStryklistQty(), is(8));
        assertThat(styklist3.getStyklist().size(), is(34));

        Stykliste styklist4 = car.carportAlgorithm(6000, 7800, 30, 0, 0, 1);
        assertNotNull(styklist4);
        assertThat(styklist4.getStyklist().get(7).getItem_description(), is("5,0 x 40 mm. beslagskruer 250 stk."));
        assertThat(styklist4.getStyklist().get(7).getStryklistQty(), is(1));
        assertThat(styklist4.getStyklist().size(), is(23));
    }

    @Test
    public void testMaterial() {
        Material mat = new Material(0, "TestMaterial", 0.0f, 0.0f, "testEntity", "test", 0f, 1);
        assertNotNull(mat);
        mat.setStyklistQty(9);
        mat.setConstructionDescription("This description!");
        mat.setLineItemID(11);
        assertThat(mat.getStryklistQty(), is(9));
        assertThat(mat.GettConstructionDescription(), is("This description!"));
        assertThat(mat.getLineItemID(), is(11));
    }

    @Test
    public void testOrder() {
        Order order = new Order(1, 6000, 7800, 2300, 0, 5300, 2100);
        assertNotNull(order);
        order.setOrderStatus(true);
        LocalDate today = LocalDate.now();
        order.setOrderdate(Date.valueOf(today));
        order.setPrice(15000f);
        assertThat(order.isOrderStatus(), is(true));
        assertThat(order.getOrderdate(), is(Date.valueOf(today)));
        assertThat(order.getPrice(), is(15000f));
    }

    @Test
    public void testStykliste() {
        ArrayList<Material> arr = new ArrayList<>();
        Stykliste styk = new Stykliste(arr, 1);
        assertNotNull(styk);
        assertThat(styk.getStyklist().size(), is(0));
    }

    @Test
    public void testGenerateSalt() {
        Encryption enc = new Encryption();
        String wordScheme = enc.generateSalt(8);
        assertNotNull(wordScheme);
    }

    @Test
    public void testGenerateSecurePassword() {
        Encryption en = new Encryption();
        String pass = "1234";
        String wordScheme = "zTajvPTS";
        byte[] securePassword = en.hash(pass.toCharArray(), wordScheme.getBytes());
        String securePass = Base64.getEncoder().encodeToString(securePassword);
        assertNotNull(securePass);
        assertThat(securePass, is("Hvt/wArJKY9e1CxGHzaoS2Sswcudy62ZAgh6wWQ3kVM="));
    }

    @Test
    public void testVerifyUserPassword() {
        Encryption en = new Encryption();
        String pass = "1234";
        String wordScheme = "zTajvPTS";
        byte[] securePassword = en.hash(pass.toCharArray(), wordScheme.getBytes());
        String securePass = Base64.getEncoder().encodeToString(securePassword);
        assertNotNull(securePass);
        assertTrue(en.verifyUserPassword(pass, securePass, wordScheme));
    }

    @Test
    public void testUser() {
        User user = new User("Test", 7, "TestUser");
        assertNotNull(user);
        Encryption en = new Encryption();
        String pass = "1234";
        String wordScheme = "zTajvPTS";
        byte[] securePassword = en.hash(pass.toCharArray(), wordScheme.getBytes());
        String securePass = Base64.getEncoder().encodeToString(securePassword);
        user.setPassword(securePass);
        assertTrue(en.verifyUserPassword(pass, user.getPassword(), wordScheme));
    }

}
