package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.StyklistException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "main", new MainPageCommand() );
        commands.put( "styklist", new StyklistPageCommand() );
        commands.put( "allmaterials", new StockMaterialsPageCommand() );
        commands.put( "editMaterial", new EditStockMaterialPageCommand() );
        commands.put( "updateMaterial", new UpdateMaterialCommand() );
        commands.put( "deleteMaterial", new DeleteStockMaterialCommand() );
        commands.put( "createMaterial", new CreateStockMaterialCommand() );
        commands.put( "styklistpage", new StyklistPageCommand());
        commands.put( "order", new OrderPageCommand());
        commands.put( "editlineitem", new EditLineItemCommand());
        commands.put("category", new categoryCommand());
        commands.put("stockListWood", new stockListWood());
        commands.put("stockListScrews", new stockListScrews());
        commands.put("graphic", new GraphicCommand());
        commands.put("AllOrders", new AllOrdersCommand());

    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException, OrderSampleException, MaterialSampleException, StyklistException;

}
