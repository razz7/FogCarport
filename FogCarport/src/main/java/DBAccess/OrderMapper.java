/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import FunctionLayer.Stykliste;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public abstract class OrderMapper {

    public static OrderMapper instance() {
        return OrderDBMapper.getInstance();
    }

    public abstract ArrayList<Order> getAllOrders() throws OrderSampleException;

    public abstract Order getOrderFromId(int order_id) throws OrderSampleException;

    public abstract Stykliste getStyklistForOrder(int order_id) throws OrderSampleException;
            
    public abstract void saveOrder(Order order) throws OrderSampleException;
        
    public abstract void finalizeOrder(int order_id) throws OrderSampleException;
    
    public abstract void deleteOrder(int order_id) throws OrderSampleException;
    
    public abstract void unFinalizeOrder(int order_id) throws OrderSampleException;
    
    public abstract void setPriceOrder(int order_id, float price) throws OrderSampleException;
    
    public abstract float getPriceFromId(int order_id) throws OrderSampleException;
        
    public static void main(String[] args) throws OrderSampleException, MaterialSampleException, LoginSampleException, ClassNotFoundException, StyklistException{
        //Order order = new Order(6000, 7800, 0, 5300, 2100, 1, 1);
        OrderMapper map = OrderMapper.instance();
        
        //map.setOrderPrice(71, 2000);
        
        //StyklisteMapper mapper = new StyklisteMapper();
    }
}
    

