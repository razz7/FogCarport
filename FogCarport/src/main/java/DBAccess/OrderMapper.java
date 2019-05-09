/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.Stykliste;
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
}
