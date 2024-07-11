package lk.Ijse.dao.custom;

import lk.Ijse.dao.CrudDAO;
import lk.Ijse.model.SupplierDTO;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO extends CrudDAO<SupplierDTO> {
    List<String> getIDS() throws SQLException, ClassNotFoundException;
}
