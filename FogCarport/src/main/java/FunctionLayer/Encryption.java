/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
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
   
   /**
    * This method creates a String with the length of the input 'length'. It then appends
    * the string with random char from the final static attribute 'alphabet'.
    * @param length
    * @return random generated word as a string
    */
   
   public String generateSalt(int length) {
       StringBuilder returnValue = new StringBuilder(length);
       for(int i = 0; i < length; ++i) {
           returnValue.append(alphabet.charAt(Random.nextInt(alphabet.length())));
           
       }
       return new String(returnValue);
       
   }
   
   /**
    * this method takes plaintext (password) along with the salt. It creates the key which is used in PBKDF2WithHmacSHA1 
    * (Password-based key-derivation function with key-hashed authentication code) which produce a
    * hash length of 160 bits. The  If salt i null it will throw a nullPointerException.
    * @param password
    * @param salt
    * @return an array of bytes made of from the password and the salt
    */
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
   
   /**
    * This method uses the above method (hash) to hash the password and salt. It then use base64
    * to encode the array of bytes to a string.
    * @param password
    * @param salt
    * @return the hashed password of the string.
    */
   public String generateSecurePassword(String password, String salt) {
       String returnValue = null;
       byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
       returnValue = Base64.getEncoder().encodeToString(securePassword);
       return returnValue;
   }
   /**
    * This method takes an user input (providedPassword) and generateSecurePassword with the
    * above methods. It will compare the user input password with the securePassword and salt,
    * which likely is stored in a database.
    * @param providedPassword
    * @param securepassword
    * @param salt
    * @return true or false depended on whether the provided password matches the stored securepassword. 
    */
   
   public boolean verifyUserPassword(String providedPassword, String securepassword, String salt) {
       boolean returnValue = false;
       
       String newSecurePassword = generateSecurePassword(providedPassword, salt);
       
       returnValue = newSecurePassword.equalsIgnoreCase(securepassword);
              
       return returnValue;
   }
   
//    public static void main(String[] args) {
//
//        Encryption encryption = new Encryption();
//   String myPassword = "hejhej";
//   String myPassword1 = "hejhej";
//   String salt = encryption.generateSalt(30);
//   String salt1 = encryption.generateSalt(30);
//        
//   
//   String mySecurePassword = encryption.generateSecurePassword(myPassword, salt);
//   String mySecurePassword1 = encryption.generateSecurePassword(myPassword1, salt1);
//       
//        
//   
//   boolean passwordMatch = encryption.verifyUserPassword(myPassword, mySecurePassword, salt);  
//   Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        
//   if(encryption.verifyUserPassword(input, mySecurePassword, salt)) {
//       
//       System.out.println("Provid password : " + myPassword + " is correct");
//       
//   } else {System.out.println("Incorrect password");
//   
//   }  
//   
//    byte[] byteArray = { 50, 60, 100}; 
//    String str = new String(byteArray);
//        System.out.println(str);

	
}



   
   
    

