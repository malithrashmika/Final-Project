package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.*;
import lk.Ijse.model.tm.OrderTm;

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
    public static List<OrderDetails> getordersAll() throws SQLException {
        String sql = "SELECT * FROM order_details_view";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<OrderDetails> ordersList = new ArrayList<>();

        while (resultSet.next()) {
            String order_id = resultSet.getString(1);
            Date date = resultSet.getDate(2);
            Time time = resultSet.getTime(3);
            String table = resultSet.getString(4);
            String cus_id = resultSet.getString(5);
            String emp_id = resultSet.getString(6);
            String itemId = resultSet.getString(7);
            double unitPrice = resultSet.getDouble(8);
            int qty = resultSet.getInt(9);
            double netTotal = resultSet.getDouble(10);

           OrderDetails orderDetails = new OrderDetails(order_id,date,time,table,cus_id,emp_id,itemId,unitPrice,qty,netTotal);
            ordersList.add(orderDetails);
        }
        return ordersList;
    }
   /* public static List<OItemtb> getorder_itemsAll() throws SQLException {
        String sql = "SELECT item_id,qty,unit_price FROM order_items";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<OItemtb> orderItemList = new ArrayList<>();

        while (resultSet.next()) {
            String itemId = resultSet.getString(1);
            int qty = resultSet.getInt(2);
            double unitPrice = resultSet.getDouble(3);

            OItemtb oItemtb = new OItemtb(itemId,qty,unitPrice);
            orderItemList.add(oItemtb);
        }
        return orderItemList;
    }*/
}