package PresentationLayerDONTREMOVE;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
  private static CommandFactory instance = null;
  private final Map<String, Command> commands = new HashMap();
  
  private CommandFactory() {
    Command backToMain = new TargetCommand("main.jsp");
    commands.put("back", backToMain);
    commands.put("cancel", backToMain);
    commands.put("null", new TargetCommand("error.jsp"));
    }
  
  public static synchronized Command commandFrom(String key) {
    if (key == null) key = "back";
    if (instance == null) instance = new CommandFactory();
    return instance.commands.get(key);
    }
  
  }
