package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ludvig
 */
public class OrderMapper {

    private Connector dbc = new Connector();

    public Order getOrderFromId(int id) throws LoginSampleException, ClassNotFoundException {
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM 'order' WHERE id = " + id + ";";
            PreparedStatement ps = con.prepareStatement(SQL);

            int ID = 0;
            float length = 0;
            float width = 0;
            float height = 0;
            float roofTilt = 0;
            float shedWidth = 0;
            float shedLength = 0;

            Order order = null;

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ID = rs.getInt("id");
                length = rs.getFloat("length");
                width = rs.getFloat("width");
                height = rs.getFloat("height");
                roofTilt = rs.getFloat("roofTilt");
                shedWidth = rs.getFloat("shedWidth");
                shedLength = rs.getFloat("shedLength");

                order = new Order(ID, height, width, length, roofTilt, shedWidth, shedLength);

            } else {
                throw new LoginSampleException("Could not validate user");
            }

            return order;

        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public ArrayList<Order> getAllOrders() throws LoginSampleException, ClassNotFoundException {
        try {
            Connection con = dbc.connection();
            String SQL = "SELECT * FROM 'order'";
            PreparedStatement ps = con.prepareStatement(SQL);

            int id = 0;
            float length = 0;
            float width = 0;
            float height = 0;
            float roofTilt = 0;
            float shedWidth = 0;
            float shedLength = 0;

            ArrayList<Order> OrderList = new ArrayList();

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
                length = rs.getFloat("length");
                width = rs.getFloat("width");
                height = rs.getFloat("height");
                roofTilt = rs.getFloat("roofTilt");
                shedWidth = rs.getFloat("shedWidth");
                shedLength = rs.getFloat("shedLength");

                Order order = new Order(id, height, width, length, roofTilt, shedWidth, shedLength);

                OrderList.add(order);
            } else {
                throw new LoginSampleException("Could not validate user");
            }

            return OrderList;

        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
