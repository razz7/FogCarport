/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

public class CommandException extends Exception{
    
    private final String target;
  
  CommandException(String message, String target) {
    super(message);
    this.target = target;
    }
  
  CommandException(String message) {
    this(message, "error.jsp");
    }
  
  public final String getTarget() { return target; }
    
}
