package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableRepo {
    public static List<String> searchById() throws SQLException {
        String sql = "SELECT table_number FROM tables";

        List<String> ids = new ArrayList<>();

        Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        while (resultSet.next()) {
            ids.add(resultSet.getString(1));
        }

        return ids;
    }
    public static Table searchById(String id) throws SQLException {
        String sql = "SELECT * FROM tables WHERE table_number = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String table_number = resultSet.getString(1);
            String capacity = resultSet.getString(2);
            String status = resultSet.getString(3);

            Table table = new Table(table_number, capacity, status);

            return table;
        }

        return null;
    }
}
