package FunctionLayer;

/**
 *
 * @author Rasmus2
 */
public class LoginSampleException extends Exception {

    private final String target;

    public LoginSampleException(String message, String target) {
        super(message);
        this.target = target;
    }

    public LoginSampleException(String message) {
        this(message, "JSP/error.jsp");
    }

    public final String getTarget() {
        return target;
    }

}
