package lk.Ijse.dao.custom.impl;

import lk.Ijse.dao.SQLUtil;
import lk.Ijse.dao.custom.SupplierDAO;
import lk.Ijse.model.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDTO> allSuppliers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM supplier");
        while (rst.next()) {
            SupplierDTO supplierDTO = new SupplierDTO(rst.getString("id"),rst.getString("name"),rst.getString("contactNumber"),rst.getString("contactEmail"));
            allSuppliers.add(supplierDTO);
        }
        return allSuppliers;
    }

    @Override
    public boolean add(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO supplier (id,name,contact,email) VALUES (?,?,?,?)", dto.getSupplierId(),dto.getSupplierName(),dto.getContactNumber(),dto.getContactEmail());

    }

    @Override
    public boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("UPDATE SUPPLIER SET name=?,contact=?,email=? WHERE id=?",dto.getSupplierName(),dto.getContactNumber(),dto.getContactEmail(),dto.getSupplierId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM SUPPLIER WHERE id=?", id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM SUPPLIER ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newSupplierId = Integer.parseInt(id.replace("S00-", "")) + 1;
            return String.format("S00-%03d", newSupplierId);
        } else {
            return "S00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Supplier WHERE id=?", id);
    }

    @Override
    public SupplierDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Supplier WHERE id=?", id + "");
        rst.next();
        return new SupplierDTO(id + "", rst.getString("name"), rst.getString("contact"), rst.getString("email"));
    }
}
