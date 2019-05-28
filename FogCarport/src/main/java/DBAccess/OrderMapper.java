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

}
