/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FunctionManager;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.OrderSampleException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ludvig
 */
public class CommandFactory {

    private static CommandFactory instance = null;
    private final Map<String, Command> commands = new HashMap();

    private CommandFactory() {
        commands.put( "main", new MainPageCommand() );
        commands.put( "styklist", new StyklistPageCommand() );
        commands.put( "allmaterials", new StockMaterialsPageCommand() );
        commands.put( "editMaterial", new EditStockMaterialPageCommand() );
        commands.put( "updateMaterial", new UpdateMaterialCommand() );
        commands.put( "deleteMaterial", new DeleteStockMaterialCommand() );
        commands.put( "createMaterial", new CreateStockMaterialCommand() );
        commands.put( "styklistpage", new StyklistPageCommand() );
        commands.put( "order", new OrderPageCommand() );
        commands.put( "editlineitem", new EditLineItemCommand() );
        commands.put( "category", new categoryCommand() );
        commands.put( "stockListWood", new stockListWood() );
        commands.put( "stockListScrews", new stockListScrews() );
        commands.put( "graphic", new GraphicCommand() );
        commands.put( "stockListTagpakke", new stockListTagpakke() );
        commands.put( "AllOrders", new AllOrdersCommand() );
        commands.put( "updateLineitem", new UpdateLineitem() );
        commands.put( "finalPrice", new PriceCommand() );
        commands.put( "percent", new FinalizeOrder() );
        commands.put( "login", new LoginCommand());

    }

    static Command commandFrom(String command) {
        if (command == null) command = "back";
        if (instance == null) instance = new CommandFactory();
        return instance.commands.get(command);
    }
    
    public static void main(String[] args){
        CommandFactory cf = new CommandFactory();
        
        
    }

}
