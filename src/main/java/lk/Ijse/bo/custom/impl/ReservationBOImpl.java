package lk.Ijse.bo.custom.impl;

import lk.Ijse.bo.SuperBO;
import lk.Ijse.bo.custom.ReservationBO;
import lk.Ijse.dao.custom.ReservationDAO;
import lk.Ijse.dao.custom.impl.ReservationDAOImpl;
import lk.Ijse.dto.ReservationDTO;
import lk.Ijse.model.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = new ReservationDAOImpl();
    @Override
    public ArrayList<ReservationDTO> getAllReservation() throws SQLException, ClassNotFoundException {
        return reservationDAO.getAll();
    }

    @Override
    public boolean addReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException {
        return reservationDAO.add(dto);
    }

    @Override
    public boolean updateReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException {
        return reservationDAO.update(dto);
    }

    @Override
    public boolean existReservation(String id) throws SQLException, ClassNotFoundException {
        return reservationDAO.exist(id);
    }

    @Override
    public boolean deleteReservation(String id) throws SQLException, ClassNotFoundException {
        return reservationDAO.delete(id);
    }

    @Override
    public ReservationDTO searchReservation(String id) throws SQLException, ClassNotFoundException {
        return reservationDAO.search(id);
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        return reservationDAO.
    }
}
