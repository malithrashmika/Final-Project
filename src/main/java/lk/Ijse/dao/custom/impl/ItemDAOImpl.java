package lk.Ijse.dao.custom.impl;

import lk.Ijse.dao.SQLUtil;
import lk.Ijse.dao.custom.ItemDAO;
import lk.Ijse.model.ItemDTO;
import lk.Ijse.model.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM item");
        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(rst.getString("item_id"),rst.getString("name"),rst.getString("description"),rst.getString("Category"),rst.getDouble("price"),rst.getInt("Qty_On_Hand"));
            allItems.add(itemDTO);
        }
        return allItems;
    }

    @Override
    public boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO item (item_id,name,description,Category,price,Qty_On_Hand) VALUES (?,?,?,?,?,?)", dto.getCode(),dto.getName(),dto.getDescription(),dto.getCategory(),dto.getPrice(),dto.getQtyOnHand());

    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE item SET name=?,description=?,Category=?,price=?,Qty_On_Hand=? WHERE item_id=?",dto.getName(),dto.getDescription(),dto.getCategory(),dto.getPrice(),dto.getQtyOnHand(),dto.getCode());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT item_id FROM item WHERE item_id=?", id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM item ORDER BY item_id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("item_id");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE item_id=?", id);
    }

    @Override
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE item_id=?", id + "");
        rst.next();
        return new ItemDTO(id + "", rst.getString("name"), rst.getString("description"), rst.getString("Category"), rst.getDouble("price"), rst.getInt("Qty_On_Hand"));
    }
}
