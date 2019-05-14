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
        commands.put( "main", new MainPageCommand("mainpage.jsp") );
        commands.put( "styklist", new StyklistPageCommand("styklist.jsp") );
        commands.put( "allmaterials", new StockMaterialsPageCommand("stockmaterialspage.jsp"));
        //commands.put( "editMaterial", new EditStockMaterialPageCommand("editlineitem.jsp") );
        commands.put( "updateMaterial", new UpdateMaterialCommand("stockmaterialspage.jsp") );
        commands.put( "deleteMaterial", new DeleteStockMaterialCommand("stockmaterialspage.jsp") );
        commands.put( "createMaterial", new CreateStockMaterialCommand("stockmaterialspage.jsp") );
        commands.put( "editMaterial", new EditStockMaterialPageCommand("editMaterial.jsp") );
        //commands.put( "updateMaterial", new UpdateMaterialCommand() );
        //commands.put( "deleteMaterial", new DeleteStockMaterialCommand("stockmaterialspage.jsp") );
        //commands.put( "createMaterial", new CreateStockMaterialCommand("stockmaterialspage.jsp") );
        //commands.put( "styklistpage", new StyklistPageCommand() );
        commands.put( "order", new OrderPageCommand("shop.jsp") );
        commands.put( "editlineitem", new EditLineItemCommand("editlineitem.jsp") );
        commands.put( "category", new categoryCommand("category.jsp") );
        commands.put( "stockListWood", new stockListWood("stockListWood.jsp") );
        commands.put( "stockListScrews", new stockListScrews("stockListScrews.jsp") );
        commands.put( "graphic", new GraphicCommand("carportSVGGraphic.jsp") );
        commands.put( "stockListTagpakke", new stockListTagpakke("stockListTagpakke.jsp") );
        commands.put( "AllOrders", new AllOrdersCommand("allOrdersPage.jsp") );
        commands.put( "updateLineitem", new UpdateLineitem("styklist.jsp") );
        commands.put( "finalPrice", new PriceCommand("PriceFinalizePage.jsp") );
        commands.put( "percent", new FinalizeOrder("allOrdersPage.sjp") );
        commands.put( "login", new LoginCommand("index.jsp"));
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
