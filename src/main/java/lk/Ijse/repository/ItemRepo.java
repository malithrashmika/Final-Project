package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepo {
    public static boolean save(Item item) throws SQLException {
        String sql = "INSERT INTO item VALUES(?, ?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getName());
        pstm.setObject(3, item.getType());
        pstm.setObject(4, item.getPrice());
        pstm.setObject(5, item.getQtyOnHand());

        return pstm.executeUpdate() > 0;
    }
    public static boolean update(Item item) throws SQLException {
        String sql = "UPDATE item SET name = ?, type = ?, price = ?, QtyOnHand = ? WHERE item_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getName());
        pstm.setObject(3, item.getType());
        pstm.setObject(4, item.getPrice());
        pstm.setObject(5, item.getQtyOnHand());


        return pstm.executeUpdate() > 0;
    }

    public static List<String> getCodes() throws SQLException {
        String sql = "SELECT item_id FROM item";
        ResultSet resultSet = DbConnection.getInstance()
                .getConnection()
                .prepareStatement(sql)
                .executeQuery();

        List<String> codeList = new ArrayList<>();
        while (resultSet.next()) {
            codeList.add(resultSet.getString(1));
        }
        return codeList;
    }

    public static Item searchById(String code) throws SQLException {
        String sql = "SELECT * FROM item WHERE item_id = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setObject(1, code);
        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5)
            );
        }
        return null;
    }
    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM item WHERE item_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT item_id FROM item";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> itemidList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            itemidList.add(id);
        }
        return itemidList;
    }
}
