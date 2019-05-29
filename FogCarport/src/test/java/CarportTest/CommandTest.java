package CarportTest;

import FunctionLayer.FunctionManager;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import PresentationLayer.Command;
import PresentationLayer.PriceCommand;
import PresentationLayer.CommandException;
import PresentationLayer.EditLineItemCommand;
import PresentationLayer.LoginCommand;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

/**
 *
 * @author Rasmus2
 */
public class CommandTest {

    @Mock
    private User users;

    @Mock
    private HttpSession session;

    @Mock
    private ArrayList<Material> arr;

    @Mock
    private Stykliste stykliste;

    @Mock
    private Order order;

    @Mock
    private FunctionManager manager;

    @Mock
    private HttpServletRequest request;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPriceCommand() throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException {
        when(request.getParameter("thisOrder")).thenReturn("76");
        when(session.getAttribute("user")).thenReturn(users);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    assertThat(key, is("price"));
                    float price = invocation.getArgument(1);
                    assertThat(price, is(0.0f));
                    return null;
                }
        ).when(request).setAttribute(any(String.class), any(Float.class));
        when(request.getSession()).thenReturn(session);
        when(manager.getOrderFromId(anyInt())).thenReturn(order);
        when(manager.getStyklistForOrder(anyInt())).thenReturn(stykliste);
        when(stykliste.getStyklist()).thenReturn(arr);

        Command command = new PriceCommand("JSP/PriceFinalizePage.jsp");
        String target = command.execute(request, manager);
        assertThat(target, is("JSP/PriceFinalizePage.jsp"));
    }

    @Test
    public void testEditLineItemCommand() throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException {
        when(request.getParameter("thisOrder")).thenReturn("80");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("lineitemID")).thenReturn("2");

        Command command = new EditLineItemCommand("JSP/editlineitem.jsp");
        String target = command.execute(request, manager);
        assertThat(target, is("index.jsp"));
    }

    @Test
    public void testLoginCommand() throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException {
        when(request.getParameter("email")).thenReturn("hej@hej.dk");
        when(request.getParameter("password")).thenReturn("hej");
        when(manager.verifyUser("hej@hej.dk", "hej")).thenReturn(true);
        when(manager.getUserByEmail("hej@hej.dk")).thenReturn(users);
        when(request.getSession()).thenReturn(session);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    assertThat(key, is("User"));
                    User user = invocation.getArgument(1);
                    assertThat(user, is(users));
                    return null;
                }
        ).when(request).setAttribute(any(String.class), any(User.class));

        Command command = new LoginCommand("JSP/home.jsp");
        String target = command.execute(request, manager);
        assertThat(target, is("JSP/home.jsp"));
    }

}