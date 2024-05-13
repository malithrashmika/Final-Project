package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.order_item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailRepo {
    public static boolean save(List<order_item> odList, Connection connection) throws SQLException {
        for (order_item od : odList) {
            if(!save((List<order_item>) od, connection)) {
                return false;
            }
        }
        return true;
    }
   private static boolean save(order_item od) throws SQLException {
        String sql = "INSERT INTO order_item VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);
        pstm.setString(1, od.getItemID());
        pstm.setString(2, od.getOrderid());
        pstm.setInt(3, od.getQty());

        return pstm.executeUpdate() > 0;
    }
}


/*import javafx.collections.ObservableList;
import lk.Ijse.db.DbConnection;
import lk.Ijse.model.order_item;
import lk.Ijse.model.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailRepo {
    public static boolean save(List<order_item> odList) {
        try (Connection connection = DbConnection.getInstance().getConnection()) {
            for (order_item od : odList) {
                if (!save(od, connection)) {
                    return false;
                }
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error saving order details: " + ex.getMessage());
            return false;
        }
    }

    public static boolean save(String od, ObservableList<CartTm> connection) throws SQLException {
        String sql = "INSERT INTO order_item (ItemID, orderid, Qty) VALUES (?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, od.getItemID());
            pstm.setString(2, od.getOrderid());
            pstm.setInt(3, od.getQty());

            return pstm.executeUpdate() > 0;
        }
    }
}*/
