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
<<<<<<< HEAD
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
        commands.put("main", new MainPageCommand("mainpage.jsp"));
        commands.put("styklist", new StyklistPageCommand("styklist.jsp"));
        commands.put("allmaterials", new StockMaterialsPageCommand("stockmaterialspage.jsp"));
        commands.put("editMaterial", new EditStockMaterialPageCommand("editMaterial.jsp"));
        commands.put("updateMaterial", new UpdateMaterialCommand("stockmaterialspage.jsp"));
        commands.put("deleteMaterial", new DeleteStockMaterialCommand("stockmaterialspage.jsp"));
        commands.put("createMaterial", new CreateStockMaterialCommand("stockmaterialspage.jsp"));
        commands.put( "styklistpage", new StyklistPageCommand("styklist.jsp"));
        commands.put("order", new OrderPageCommand("shop.jsp"));
        commands.put("editlineitem", new EditLineItemCommand("editlineitem.jsp"));
        commands.put("category", new categoryCommand("category.jsp"));
        commands.put("stockListWood", new stockListWood("stockListWood.jsp"));
        commands.put("stockListScrews", new stockListScrews("stockListScrews.jsp"));
        commands.put("graphic", new GraphicCommand("carportSVGGraphic.jsp"));
        commands.put("stockListTagpakke", new stockListTagpakke("stockListTagpakke.jsp"));
        commands.put("AllOrders", new AllOrdersCommand("allOrdersPage.jsp"));
        commands.put("updateLineitem", new UpdateLineitem("styklist.jsp"));
        commands.put("finalPrice", new PriceCommand("PriceFinalizePage.jsp"));
        commands.put("percent", new FinalizeOrder("allOrdersPage.sjp"));
        commands.put("login", new LoginCommand("index.jsp"));
=======
        commands.put("main", new MainPageCommand("JSP/mainpage.jsp"));
        commands.put("styklist", new StyklistPageCommand("JSP/styklist.jsp"));
        commands.put("allmaterials", new StockMaterialsPageCommand("JSP/stockmaterialspage.jsp"));
        commands.put("editMaterial", new EditStockMaterialPageCommand("JSP/editMaterial.jsp"));
        commands.put("updateMaterial", new UpdateMaterialCommand("JSP/stockmaterialspage.jsp"));
        commands.put("deleteMaterial", new DeleteStockMaterialCommand("JSP/stockmaterialspage.jsp"));
        commands.put("createMaterial", new CreateStockMaterialCommand("JSP/stockmaterialspage.jsp"));
        commands.put( "styklistpage", new StyklistPageCommand("JSP/styklist.jsp"));
        commands.put("order", new OrderPageCommand("JSP/shop.jsp"));
        commands.put("editlineitem", new EditLineItemCommand("JSP/editlineitem.jsp"));
        commands.put("category", new categoryCommand("JSP/category.jsp"));
        commands.put("stockListWood", new stockListWood("JSP/stockListWood.jsp"));
        commands.put("stockListScrews", new stockListScrews("JSP/stockListScrews.jsp"));
        commands.put("graphic", new GraphicCommand("JSP/carportSVGGraphic.jsp"));
        commands.put("stockListTagpakke", new stockListTagpakke("JSP/stockListTagpakke.jsp"));
        commands.put("AllOrders", new AllOrdersCommand("JSP/allOrdersPage.jsp"));
        commands.put("updateLineitem", new UpdateLineitem("JSP/styklist.jsp"));
        commands.put("finalPrice", new PriceCommand("JSP/PriceFinalizePage.jsp"));
        commands.put("percent", new FinalizeOrder("JSP/allOrdersPage.sjp"));
        commands.put("login", new LoginCommand("JSP/index.jsp"));
>>>>>>> 3f450039159ca45985389bea48f1dc3b8fcdb78e
    }

    public static synchronized Command commandFrom(String key) {
    if (key == null) key = "back";
    if (instance == null) instance = new CommandFactory();
    return instance.commands.get(key);
    }

}
