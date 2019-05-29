/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

/**
 *
 * @author Rasmus2
 */
public class CommandException extends Exception {

    private final String target;

    /**
     * CommandException constructor
     *
     * @param message
     * @param target
     */
    CommandException(String message, String target) {
        super(message);
        this.target = target;
    }

    /**
     * CommandException constructor
     *
     * @param message
     */
    CommandException(String message) {
        this(message, "JSP/error.jsp");
    }

    /**
     * Returns target
     *
     * @return String
     */
    public final String getTarget() {
        return target;
    }

}
