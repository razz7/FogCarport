/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Rasmus2
 */
public class OrderSampleException extends Exception {

    private final String target;

    /**
     * Constructor for OrderSampleException
     * 
     * @param message
     * @param target 
     */
    public OrderSampleException(String message, String target) {
        super(message);
        this.target = target;
    }
    //"error.jsp"

    /**
     * Constructor for OrderSampleException
     * 
     * @param message 
     */
    public OrderSampleException(String message) {
        this(message, "JSP/error.jsp");
    }

    /**
     * Returns target
     * 
     * @return target
     */
    public final String getTarget() {
        return target;
    }

}
