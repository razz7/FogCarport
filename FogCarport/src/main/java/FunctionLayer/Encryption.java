/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;
import javax.crypto.spec.PBEKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.SecretKeyFactory;

/**
 *
 * @author Rumle
 */
public class Encryption {

   private static final Random Random = new SecureRandom();
   private static final String alphabet =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   private static final int ITERATIONS = 100000;
   private static final int KEY_LENGTH= 256;
   private Scanner scanner = new Scanner(System.in);
   
   public String getSalt(int length) {
       StringBuilder returnValue = new StringBuilder(length);
       
       for(int i = 0; i < length; ++i) {
           returnValue.append(alphabet.charAt(Random.nextInt(alphabet.length())));
           
       }
       return new String(returnValue);
   }
   public byte[] hash(char[] password, byte[] salt) {
       PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
       Arrays.fill(password, Character.MIN_VALUE );
       try {
           SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
           return skf.generateSecret(spec).getEncoded();
       } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
           throw new AssertionError("Error" + e.getMessage());
       } finally {
           spec.clearPassword();
               
           }
           
       }
   public String generateSecurePassword(String password, String salt) {
       String returnValue = null;
       
       byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
       
       returnValue = Base64.getEncoder().encodeToString(securePassword);
       return returnValue;
   }
   
   public boolean verifyUserPassword(String providedPassword, String securepassword, String salt) {
       boolean returnValue = false;
       
       String newSecurePassword = generateSecurePassword(providedPassword, salt);
       
       returnValue = newSecurePassword.equalsIgnoreCase(securepassword);
       
       
       return returnValue;
   }
   
    public static void main(String[] args) {
        
//    
//   
//   String myPassword = "hejhej";
//   String myPassword1 = "hejhej";
//   String salt = Encryption.getSalt(30);
//   String salt1 = Encryption.getSalt(30);
//        System.out.println(salt);
//        System.out.println(salt1);
//   
//   String mySecurePassword = Encryption.generateSecurePassword(myPassword, salt);
//   String mySecurePassword1 = Encryption.generateSecurePassword(myPassword1, salt1);
//        System.out.println(mySecurePassword);
//        System.out.println(mySecurePassword1);
//        
//   
//   boolean passwordMatch = Encryption.verifyUserPassword(myPassword, mySecurePassword, salt);
//   
//   
//   
//   Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        
//   if(Encryption.verifyUserPassword(input, mySecurePassword, salt)) {
//       
//       System.out.println("Provid password : " + myPassword + " is correct");
//       
//   } else {System.out.println("Incorrect password");
//   
//   }
//       
//        
//   
//   }
}
}
   
   
    

