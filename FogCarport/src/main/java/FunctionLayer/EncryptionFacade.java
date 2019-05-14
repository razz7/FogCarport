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
public abstract class EncryptionFacade {
    
     public abstract String getSalt(int length);
     
     public abstract byte[] hash(char[] password, byte[] salt);
     
     public abstract String generateSecurePassword(String password, String salt);
     
     public abstract boolean verifyUserPassword(String providedPassword, String securepassword, String salt);
    
}
