/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author rasmu
 */
public class LogicFacade implements LogicFacadeInterface {

    @Override
    public FunctionLayer.Stykliste carportAlgorithm(float width, float length, float roofTilt, float shedwidth, float shedLength, int styklist_id) throws MaterialSampleException {
        CarportAlgorithm car = new CarportAlgorithm();
        return car.carportAlgorithm(width, length, roofTilt, shedwidth, shedLength, styklist_id);
    }

    @Override
    public FunctionLayer.Material Material(int item_id, String item_description, float width, float height, String entity, String materialtype, float price, int versionnr) {
        Material mat = new Material(item_id, item_description, width, height, entity, materialtype, price, versionnr);
        return mat;
    }

    @Override
    public FunctionLayer.Order Order(int order_id, float width, float length, float height, float roofTilt, float shedWidth, float shedLength) {
        Order order = new Order(order_id, width, length, height, roofTilt, shedWidth, shedLength);
        return order;
    }

    @Override
    public FunctionLayer.Stykliste Stykliste(ArrayList<FunctionLayer.Material> styklist, int styklist_id) {
        Stykliste styk = new Stykliste(styklist, styklist_id);
        return styk;
    }

    @Override
    public FunctionLayer.User User(String email, String password, String role) {
        User user = new User(email, password, role);
        return user;
    }

    @Override
    public String getSalt(int length) {
        Encryption enc = new Encryption();
        return enc.getSalt(length);
    }

    @Override
    public String generateSecurePassword(String password, String salt) {
        Encryption enc = new Encryption();
        return enc.generateSecurePassword(password, salt);
    }

    @Override
    public boolean verifyUserPassword(String providedPassword, String securepassword, String salt) {
        Encryption enc = new Encryption();
        return enc.verifyUserPassword(providedPassword, securepassword, salt);
    }

}
