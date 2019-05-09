/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import FunctionLayer.MaterialSampleException;
import FunctionLayer.Stykliste;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public abstract class MaterialMapper {

    public static MaterialMapper instance() {
        return MaterialDBMapper.getInstance();
    }

    public abstract ArrayList<Material> getAllMaterials() throws MaterialSampleException;
            
    public abstract void addNewMaterial(String item_description, float width, float height, String entity, String materialtype, float price, int quantity)throws MaterialSampleException;
            
    public abstract void updateMaterialData(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int quantity)throws MaterialSampleException, ClassNotFoundException ;
            
    public abstract void deleteMaterial(int item_id)throws MaterialSampleException;
            
    public abstract Material getMaterialbyID(int item_id) throws MaterialSampleException;
            
    public abstract Stykliste getLineitemsByOrderId(int order_id)throws MaterialSampleException;
            
    public abstract ArrayList<Material> getAllMaterialbyType(String type)throws MaterialSampleException;
}
