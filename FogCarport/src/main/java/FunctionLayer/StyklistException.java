/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Rumle
 */
public class StyklistException extends Exception{
   
         private final String target;
  
    public StyklistException(String message, String target) {
    super(message);
    this.target = target;
    }
  
    public StyklistException(String message) {
    this(message, "JSP/error.jsp");
    }
  
  public final String getTarget() { return target; }
  
  }
