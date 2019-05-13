package FunctionLayer;

/**
 *
 * @author Rasmus2
 */
public class User {

    public User( String email, int id, String role ) {
        this.email = email;
        this.id = id;
        this.role = role;
    }

    private int id;
    private String email;
    private String password;
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

}
