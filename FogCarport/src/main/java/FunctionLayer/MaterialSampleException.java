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
public class MaterialSampleException extends Exception {

    private final String target;

    /**
     * Constructor for MaterialSampleException
     * 
     * @param message
     * @param target 
     */
    public MaterialSampleException(String message, String target) {
        super(message);
        this.target = target;
    }
    //"error.jsp"

    /**
     * MaterialSampleException
     * 
     * @param message 
     */
    public MaterialSampleException(String message) {
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
