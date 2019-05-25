/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author Rumle
 */
public interface LogicFacadeInterface {

    public Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException;

    public Material Material(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int versionnr);

    public Order Order(int order_id, float width, float length, float height, float roofTilt, float shedWidth, float shedLength);

    public Stykliste Stykliste(ArrayList<Material> styklist, int styklist_id);

    public User User(String email, int id, String role);

    public String generateSalt(int length);

    public String generateSecurePassword(String password, String salt);

    public boolean verifyUserPassword(String providedPassword, String securepassword, String salt);

}
