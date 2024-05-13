package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Customer;
import lk.Ijse.model.Order;
import lk.Ijse.model.PlaceOrder;
import lk.Ijse.model.order_item;
import lk.Ijse.model.tm.OrderTm;
import lk.Ijse.repository.ItemRepo;
import lk.Ijse.repository.OrderDetailRepo;
import lk.Ijse.repository.OrderRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderRepo {
    public static boolean placeOrder(PlaceOrder po) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isOrderSaved = OrderRepo.save(po.getOrder());
            if (isOrderSaved) {
                boolean isOrderDetailSaved = OrderDetailRepo.save(po.getOdList());
                if (isOrderDetailSaved) {
                    boolean isItemQtyUpdate = ItemRepo.updateQty(po.getOdList());
                    if (isItemQtyUpdate) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } catch (Exception e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }
   /* public static List<Order> getordersAll() throws SQLException {
        String sql = "SELECT * FROM orders";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Order> ordersList = new ArrayList<>();

        while (resultSet.next()) {
            String order_id = resultSet.getString(1);
            Date date = resultSet.getDate(2);
            Time time = resultSet.getTime(3);
            String table = resultSet.getString(4);
            String cus_id = resultSet.getString(4);
            double netTotal = resultSet.getDouble(4);

           Order order = new Order(order_id,date,time,table,cus_id,netTotal);
            ordersList.add(order);
        }
        return ordersList;
    }
    public static List<order_item> getorder_itemsAll() throws SQLException {
        String sql = "SELECT item_id,qty,unit_price FROM order_items";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<order_item> orderItemList = new ArrayList<>();

        while (resultSet.next()) {
            String itemId = resultSet.getString(1);
            int qty = resultSet.getInt(2);
            double unitPrice = resultSet.getDouble(4);

            order_item oi = new Order(itemId,qty,unitPrice);
            orderItemList.add(oi);
        }
        return orderItemList;
    }*/
}