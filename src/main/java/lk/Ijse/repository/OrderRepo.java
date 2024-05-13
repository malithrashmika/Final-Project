
package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Order;

import java.sql.*;

public class OrderRepo {
    public static String getCurrentId() throws SQLException {
        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            String orderId = resultSet.getString(1);
            return orderId;
        }
        return null;
    }
//    public static boolean save(Order order) throws SQLException {
//        String sql = "INSERT INTO orders VALUES(?, ?, ?, ?, ?, ?)";
//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//        pstm.setString(1, order.getOrderId());
//        pstm.setDate(2, order.getOrderDate());
//        pstm.setDate(3, Date.valueOf(order.getOrderTime()));
//        pstm.setString(4, order.getTable());
//        pstm.setString(5, order.getCustomerId());
//        pstm.setString(6,order.getEmployeeId());
//
//
//        return pstm.executeUpdate() > 0;
//    }
public static boolean save(Order order, Connection connection) throws SQLException {
    String sql = "INSERT INTO orders VALUES(?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql)) {
        pstm.setString(1, order.getOrderId());
        pstm.setDate(2, Date.valueOf(order.getOrderDate().toLocalDate())); // Convert LocalDate to SQL Date
        pstm.setTime(3, Time.valueOf(order.getOrderTime())); // Convert LocalTime to SQL Time
        pstm.setString(4, order.getTable());
        pstm.setString(5, order.getCustomerId());
        pstm.setString(6, order.getEmployeeId());

        return pstm.executeUpdate() > 0;
    }
}



}


/*
package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Order;
import lk.Ijse.model.order_item;

import java.sql.*;
import java.util.List;

public class OrderRepo {

    public static String getCurrentId() throws SQLException {
        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
        try (PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        }
        return null;
    }

    public static boolean save(Order order, List<order_item> orderItems) throws SQLException {
        Connection connection = null;
        PreparedStatement orderPstm = null;
        PreparedStatement orderItemPstm = null;
        ResultSet generatedKeys = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Insert into orders table
            String orderSql = "INSERT INTO orders (order_id, order_date, order_time, table_number, customer_id, employee_id) VALUES (?, ?, ?, ?, ?, ?)";
            orderPstm = connection.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
            orderPstm.setString(1, order.getOrderId());
            orderPstm.setDate(2, Date.valueOf(order.getOrderDate().toLocalDate())); // Convert LocalDate to SQL Date
            orderPstm.setTime(3, Time.valueOf(order.getOrderTime())); // Convert LocalTime to SQL Time
            orderPstm.setString(4, order.getTable());
            orderPstm.setString(5, order.getCustomerId());
            orderPstm.setString(6, order.getEmployeeId());

            int affectedRows = orderPstm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert order, no rows affected.");
            }

            // Get the generated order ID
            generatedKeys = orderPstm.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new SQLException("Failed to get generated order ID.");
            }
            int orderId = generatedKeys.getInt(1);

            // Insert into order_items table
            String orderItemSql = "INSERT INTO order_items (order_id, item_id, qty) VALUES (?, ?, ?)";
            orderItemPstm = connection.prepareStatement(orderItemSql);
            for (order_item item : orderItems) {
                orderItemPstm.setInt(1, orderId);
                orderItemPstm.setString(2, item.getItemID());
                orderItemPstm.setInt(3, item.getQty());
                orderItemPstm.addBatch();
            }

            int[] batchResult = orderItemPstm.executeBatch();

            // Commit transaction
            connection.commit();
            return true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback if any exception occurs
                } catch (SQLException ex) {
                    System.err.println("Error rolling back transaction: " + ex.getMessage());
                }
            }
            throw e;
        } finally {
            // Close all resources
            if (generatedKeys != null) {
                generatedKeys.close();
            }
            if (orderItemPstm != null) {
                orderItemPstm.close();
            }
            if (orderPstm != null) {
                orderPstm.close();
            }
            if (connection != null) {
                connection.setAutoCommit(true); // Restore auto-commit mode
                connection.close();
            }
        }
    }
}
*/
