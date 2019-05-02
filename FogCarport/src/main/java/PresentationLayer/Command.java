package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private HashMap<String, Command> commands;

    private void initCommands() {
        commands = new HashMap<>();
        commands.put( "main", new MainPage() );
        commands.put( "styklist", new StyklistPage() );
        commands.put( "allmaterials", new StockMaterialsPage() );
        commands.put( "editMaterial", new EditStockMaterialPage() );
        commands.put( "updateMaterial", new UpdateMaterial() );
        commands.put( "deleteMaterial", new DeleteStockMaterial() );
        commands.put( "createMaterial", new CreateStockMaterial() );
        commands.put( "styklistpage", new StyklistPage());
        commands.put( "order", new OrderPage());
        commands.put( "editlineitem", new EditLineItem());
        
    }

    Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException;

}
