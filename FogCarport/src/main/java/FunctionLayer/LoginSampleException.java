package FunctionLayer;

/**
 *
 * @author Rasmus2
 */
public class LoginSampleException extends Exception {

    private final String target;

    /**
     * Constructor for LoginSampleException
     * 
     * @param message
     * @param target 
     */
    public LoginSampleException(String message, String target) {
        super(message);
        this.target = target;
    }

    /**
     * Constructor for LoginSampleException
     * 
     * @param message 
     */
    public LoginSampleException(String message) {
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
