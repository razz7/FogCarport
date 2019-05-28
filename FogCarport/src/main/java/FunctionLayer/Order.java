/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.sql.Date;

/**
 *
 * @author Ludvig
 */
public class Order {

    private int order_id;
    private float width;
    private float length;
    private float height;
    private float roofTilt;
    private float shedWidth;
    private float shedLength;
    private float price;
    private User user;
    private Stykliste styklist;
    private boolean orderStatus;
    private Date orderdate;

    /**
     * Order constructor takes an integer and multiple floats
     * 
     * @param order_id
     * @param width
     * @param length
     * @param height
     * @param roofTilt
     * @param shedWidth
     * @param shedLength 
     */
    public Order(int order_id, float width, float length, float height, float roofTilt, float shedWidth, float shedLength) {
        this.order_id = order_id;
        this.width = width;
        this.length = length;
        this.height = height;
        this.roofTilt = roofTilt;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
    }

    /**
     * Sets price for order object
     * 
     * @param price 
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Returns price field for order object
     * 
     * @return price 
     */
    public float getPrice() {
        return price;
    }
    
    /**
     * Sets user for order object
     * 
     * @param user 
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets order id for order object
     * 
     * @param order_id 
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * Sets styklist for order object
     * 
     * @param styklist 
     */
    public void setStyklist(Stykliste styklist) {
        this.styklist = styklist;
    }

    /**
     * Returns user from order object
     * 
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns order id for order object
     * 
     * @return order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * Returns width for order object
     * 
     * @return width
     */
    public float getWidth() {
        return width;
    }

    /**
     * Returns length for order object
     * 
     * @return length
     */
    public float getLength() {
        return length;
    }

    /**
     * Returns height for order object
     * 
     * @return height 
     */
    public float getHeight() {
        return height;
    }

    /**
     * Returns roofTilt for order object
     * 
     * @return roofTilt
     */
    public float getRoofTilt() {
        return roofTilt;
    }

    /**
     * Returns shedWidth for order object
     * 
     * @return shedWidth
     */
    public float getShedWidth() {
        return shedWidth;
    }

    /**
     * Returns shedLength for order object
     * 
     * @return shedLength
     */
    public float getShedLength() {
        return shedLength;
    }

    /**
     * Sets orderStatus for order object
     * 
     * @param orderStatus 
     */
    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    /**
     * Returns stykliste for order object
     * 
     * @return styklist
     */
    public Stykliste getStyklist() {
        return styklist;
    }

    /**
     * Returns orderStatus for object
     * 
     * @return orderStatus
     */
    public boolean isOrderStatus() {
        return orderStatus;
    }

    /**
     * Returns orderDate for object
     * 
     * @return orderdate
     */
    public Date getOrderdate() {
        return orderdate;
    }

    /**
     * Sets orderdate for order object
     * 
     * @param orderdate 
     */
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
    
    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", width=" + width + ", length=" + length + ", height=" + height + ", roofTilt=" + roofTilt + ", shedWidth=" + shedWidth + ", shedLength=" + shedLength + ", user=" + user + ", styklist=" + styklist + ", orderStatus=" + orderStatus + '}';
    }

}
