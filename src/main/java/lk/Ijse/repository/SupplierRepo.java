package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Ingredient;
import lk.Ijse.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepo {
    public static boolean save(Supplier supplier) throws SQLException {
        String sql = "INSERT INTO supplier VALUES(?, ?, ?, ?)";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,supplier.getSupplierId());
        pstm.setObject(2,supplier.getSupplierName());
        pstm.setObject(3,supplier.getContactNumber());
        pstm.setObject(4,supplier.getContactEmail());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update(Supplier supplier) throws SQLException {
        String sql = "UPDATE supplier SET name = ?, contact = ?, email =? WHERE supplier_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, supplier.getSupplierName());
        pstm.setObject(2, supplier.getContactNumber());
        pstm.setObject(3, supplier.getContactEmail());
        pstm.setObject(4, supplier.getSupplierId());

        return pstm.executeUpdate() > 0;
    }
    public static List<String> searchById() throws SQLException {
        String sql = "SELECT supplier_id FROM supplier";

        List<String> ids = new ArrayList<>();

        Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        while (resultSet.next()) {
            ids.add(resultSet.getString(1));
        }

        return ids;
    }
    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM supplier WHERE supplier_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }
    public static List<Supplier> getAll() throws SQLException {
        String sql = "SELECT * FROM supplier";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Supplier> supList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String tel = resultSet.getString(3);
            String email = resultSet.getString(4);

            Supplier supplier = new Supplier(id, name, tel, email);
            supList.add(supplier);
        }
        return supList;
    }

    public static List<String> getIds() throws SQLException {
        String sql = "SELECT supplier_id FROM supplier";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }
    public static Supplier searchById(String id) throws SQLException {
        String sql = "SELECT * FROM supplier WHERE supplier_id = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setObject(1, id);
        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return new Supplier(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)

            );
        }
        return null;
    }
}
