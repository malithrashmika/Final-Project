package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientsRepo {
    public static boolean save(Ingredient ingredient) throws SQLException {
        String sql = "INSERT INTO ingredient VALUES(?, ?, ?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, ingredient.getIngredient_id());
        pstm.setObject(2, ingredient.getIngredient_name());
        pstm.setObject(3, ingredient.getCategory());
        pstm.setObject(4, ingredient.getQty_avalible());
        pstm.setObject(5, ingredient.getUnit_price());
        pstm.setObject(6, ingredient.getSupplier_id());

        return pstm.executeUpdate() > 0;
    }
    public static boolean update(Ingredient ingredient) throws SQLException {
        String sql = "UPDATE ingredient SET name = ?, category=?, qty_available = ?, unit_price = ?, supplier_id = ? WHERE ingredient_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setObject(1, ingredient.getIngredient_name());
        pstm.setObject(2, ingredient.getCategory());
        pstm.setObject(3, ingredient.getQty_avalible());
        pstm.setObject(4, ingredient.getUnit_price());
        pstm.setObject(5, ingredient.getSupplier_id());
        pstm.setObject(6, ingredient.getIngredient_id());


        return pstm.executeUpdate() > 0;
    }

    public static List<Ingredient> getAll() throws SQLException {
        String sql = "SELECT * FROM ingredient";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Ingredient> ingredientList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String category = resultSet.getString(3);
            int qty_available = 0;
            double price = Double.parseDouble(resultSet.getString(5));
            String supplier = resultSet.getString(6);
               //this is line 63
            try {
                String qtyString = resultSet.getString(4);
                if (qtyString != null && !qtyString.isEmpty()) {
                    qty_available = Integer.parseInt(qtyString);
                }
            } catch (NumberFormatException e) {
                // Handle the case where parsing fails
                // You can log an error, set a default value, or take other appropriate action
                e.printStackTrace(); // Example: Print the stack trace for debugging
            }

            Ingredient ingredient = new Ingredient(id, name, category, qty_available,price, supplier);
            ingredientList.add(ingredient);
        }
        return ingredientList;
    }

    public static Ingredient searchById(String id) throws SQLException {
        String sql = "SELECT * FROM ingredient WHERE ingredient_id = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setObject(1, id);
        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return new Ingredient(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6)

            );
        }
        return null;
    }
    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM ingredient WHERE ingredient_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }
    public static List<String> getcode() throws SQLException {
        String sql = "SELECT ingredient_id FROM ingredient";
        ResultSet resultSet = DbConnection.getInstance()
                .getConnection()
                .prepareStatement(sql)
                .executeQuery();

        List<String> idList = new ArrayList<>();
        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
}
