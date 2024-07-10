package lk.Ijse.bo.custom;

import lk.Ijse.model.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO {
    public ArrayList<SupplierDTO> getAllSuppliers() throws SQLException, ClassNotFoundException;

    public boolean addSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean existSupplier(String id) throws SQLException, ClassNotFoundException;

    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException;

    public String generateNewSupplierID() throws SQLException, ClassNotFoundException;
}
