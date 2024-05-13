package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Order;
import lk.Ijse.model.PlaceOrder;
import lk.Ijse.model.order_item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlaceOrderRepo {

    public static boolean placeOrder(PlaceOrder placeOrder) {
        Connection connection = null;
        PreparedStatement orderStatement = null;
        PreparedStatement orderItemStatement = null;

        try {
            // Get a database connection
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Insert order details
            String orderSql = "INSERT INTO orders (orderId, customerId, orderDate, orderTime, Table, employeeId) VALUES (?, ?, ?, ?, ?, ?)";
            orderStatement = connection.prepareStatement(orderSql);
            Order order = placeOrder.getOrder();
            orderStatement.setString(1, order.getOrderId());
            orderStatement.setString(2, order.getCustomerId());
            orderStatement.setDate(3, order.getOrderDate());
            orderStatement.setString(4, order.getOrderTime());
            orderStatement.setString(5, order.getTable());
            orderStatement.setString(6, order.getEmployeeId());
            orderStatement.executeUpdate();

            // Insert order items
            String orderItemSql = "INSERT INTO order_item (orderId, ItemID, Qty) VALUES (?, ?, ?)";
            orderItemStatement = connection.prepareStatement(orderItemSql);
            List<order_item> orderItems = placeOrder.getOdList();
            for (order_item item : orderItems) {
                orderItemStatement.setString(1, order.getOrderId());
                orderItemStatement.setString(2, item.getItemID());
                orderItemStatement.setInt(3, item.getQty());
                orderItemStatement.addBatch();
            }
            orderItemStatement.executeBatch();

            connection.commit(); // Commit transaction
            return true;
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback(); // Rollback transaction if an error occurs
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (orderStatement != null) {
                    orderStatement.close();
                }
                if (orderItemStatement != null) {
                    orderItemStatement.close();
                }
                if (connection != null) {
                    connection.setAutoCommit(true); // Restore auto-commit mode
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
