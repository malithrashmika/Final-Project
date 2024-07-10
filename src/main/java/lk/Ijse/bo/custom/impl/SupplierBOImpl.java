package lk.Ijse.bo.custom.impl;

import lk.Ijse.bo.custom.SupplierBO;
import lk.Ijse.dao.custom.SupplierDAO;
import lk.Ijse.dao.custom.impl.SupplierDAOImpl;
import lk.Ijse.model.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
    @Override
    public ArrayList<SupplierDTO> getAllSuppliers() throws SQLException, ClassNotFoundException {
        SupplierDAO supplierDAO=new SupplierDAOImpl();
        return supplierDAO.getAll();
    }

    @Override
    public boolean addSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        SupplierDAO supplierDAO=new SupplierDAOImpl();
        return supplierDAO.add(dto);
    }

    @Override
    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        SupplierDAO supplierDAO=new SupplierDAOImpl();
        return supplierDAO.update(dto);
    }

    @Override
    public boolean existSupplier(String id) throws SQLException, ClassNotFoundException {
        SupplierDAO supplierDAO=new SupplierDAOImpl();
        return supplierDAO.exist(id);
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        SupplierDAO supplierDAO=new SupplierDAOImpl();
        return supplierDAO.delete(id);
    }

    @Override
    public String generateNewSupplierID() throws SQLException, ClassNotFoundException {
        SupplierDAO supplierDAO=new SupplierDAOImpl();
        return supplierDAO.generateNewID();
    }
}
