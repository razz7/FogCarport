///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package CarportTest;
//
//import FunctionLayer.FunctionManager;
//import FunctionLayer.LogicFacade;
//import FunctionLayer.LoginSampleException;
//import FunctionLayer.MaterialSampleException;
//import FunctionLayer.OrderSampleException;
//import FunctionLayer.StyklistException;
//import PresentationLayer.Command;
//import PresentationLayer.PriceCommand;
//import PresentationLayer.CommandException;
//import javax.servlet.http.HttpServletRequest;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.mockito.Mock;
//import static org.mockito.ArgumentMatchers.any;
//import org.mockito.MockitoAnnotations;
//import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.Mockito.*;
//import org.mockito.stubbing.Answer;
//
///**
// *
// * @author rasmu
// */
//public class CommandTest {
//
//    private String url = "jdbc:mysql://167.99.209.155/fog?useUnicode=yes&characterEncoding=utf-8";
//    private String user = "fog";
//    private String password = "projectFog:1234_5";
//
//    @Mock
//    private FunctionManager manager;
//
//    @Mock
//    private HttpServletRequest request;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testPriceCommand() throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException, CommandException, ClassNotFoundException {
//        when(request.getParameter("thisOrder")).thenReturn("76");
//        doAnswer(
//                invocation -> {
//                    String key = invocation.getArgument(0);
//                    assertThat(key, is("price"));
//                    float price = invocation.getArgument(1);
//                    assertThat(price, is(47.11f));
//                    return null;
//                }
//        ).when(request).setAttribute(any(String.class), any(Float.class));
//        when(manager.getOrderFromId(Integer.parseInt("76")).getPrice()).thenReturn(47.11f);
//        Command command = new PriceCommand("JSP/PriceFinalizePage.jsp");
//        String target = command.execute(request, manager);
//        assertThat(target, is("JSP/PriceFinalizePage.jsp"));
//    }
//    /*
//    @Test
//    public void testPriceCommand2() {
//        when(request.getParameter("code")).thenReturn("XYZ11");
//        //doNothing().when(request).setAttribute(any(String.class), any(Double.class));
//        doAnswer(
//                invocation -> {
//                    String key = invocation.getArgument(0);
//                    assertThat(key, is("price"));
//                    double price = invocation.getArgument(1);
//                    assertThat(price, is(47.11));
//                    return null;
//                }
//        ).when(request).setAttribute(any(String.class), any(Double.class));
//        when(logic.getPrice("XYZ11")).thenReturn(47.11);
//        Command command = new PriceCommand();
//        String target = command.execute(request, logic);
//        assertThat(target, is("pricepage.jsp"));
//    }
//     */
//}
