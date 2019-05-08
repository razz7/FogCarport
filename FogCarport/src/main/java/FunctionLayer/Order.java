/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

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
    private User user;
    private Stykliste styklist;
    private boolean orderStatus;

    public Order(int order_id, float width, float length, float height, float roofTilt, float shedWidth, float shedLength) {
        this.order_id = order_id;
        this.width = width;
        this.length = length;
        this.height = height;
        this.roofTilt = roofTilt;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setStyklist(Stykliste styklist) {
        this.styklist = styklist;
    }

    public User getUser() {
        return user;
    }

    public int getOrder_id() {
        return order_id;
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getRoofTilt() {
        return roofTilt;
    }

    public float getShedWidth() {
        return shedWidth;
    }

    public float getShedLength() {
        return shedLength;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }


    public Stykliste getSl() {
        return sl;
    }
    

    public Stykliste getStyklist() {
        return styklist;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }


    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", width=" + width + ", length=" + length + ", height=" + height + ", roofTilt=" + roofTilt + ", shedWidth=" + shedWidth + ", shedLength=" + shedLength + ", user=" + user + ", styklist=" + styklist + ", orderStatus=" + orderStatus + '}';
    }

}
