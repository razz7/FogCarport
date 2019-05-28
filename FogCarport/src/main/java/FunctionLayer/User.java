package FunctionLayer;

/**
 *
 * @author Rasmus2
 */
public class User {
    
    private int id;
    private String email;
    private String password;
    private String role;

    /**
     * Constructor of User object
     * 
     * @param email
     * @param id
     * @param role 
     */
    public User( String email, int id, String role ) {
        this.email = email;
        this.id = id;
        this.role = role;
    }

    /**
     * Returns email parameter
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email parameter
     * 
     * @param email 
     */
    public void setEmail( String email ) {
        this.email = email;
    }

    /**
     * Returns password field
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password field
     * 
     * @param password 
     */
    public void setPassword( String password ) {
        this.password = password;
    }

    /**
     * Returns role parameter
     * 
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role parameter
     * 
     * @param role 
     */
    public void setRole( String role ) {
        this.role = role;
    }

    /**
     * Returns id parameter
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id parameter
     * 
     * @param id 
     */
    public void setId( int id ) {
        this.id = id;
    }

}
