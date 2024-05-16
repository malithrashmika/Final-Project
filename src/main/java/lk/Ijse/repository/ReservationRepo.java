package lk.Ijse.repository;

import lk.Ijse.db.DbConnection;
import lk.Ijse.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepo {
    public static String getCurrentId() throws SQLException {
        String sql = "SELECT reservation_id FROM reservation ORDER BY reservation_id DESC LIMIT 1";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            String RId = resultSet.getString(1);
            return RId;
        }
        return null;
    }

    public static boolean save(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservation VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql)) {
            pstm.setString(1, reservation.getReservationId());
            pstm.setDate(2, reservation.getDate_of_reservation());
            pstm.setDate(3, reservation.getReserved_date()); // Convert LocalDate to SQL Date
            pstm.setTime(4, reservation.getReserved_time());
            pstm.setString(5, reservation.getEmployee_id());
            pstm.setString(6, reservation.getTable_Number());
            pstm.setString(7,reservation.getCustomer_id());
            pstm.setString(8, reservation.getStart_time());
            pstm.setString(9, reservation.getEnd_time());
            pstm.setString(10,reservation.getEvent());

            return pstm.executeUpdate() > 0;
        }
    }
    public static boolean update(Reservation reservation) throws SQLException {
        String sql = "UPDATE reservation SET  date_of_reservation= ?, reserved_date = ?, reserved_time =?,employee_id=?,table_number=?,customer_id=? ,start_time=?,end_time=?,event=?WHERE  reservation_id= ?";
        try (PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql)) {
            pstm.setDate(1, reservation.getDate_of_reservation());
            pstm.setDate(2, reservation.getReserved_date()); // Convert LocalDate to SQL Date
            pstm.setTime(3, reservation.getReserved_time());
            pstm.setString(4, reservation.getEmployee_id());
            pstm.setString(5, reservation.getTable_Number());
            pstm.setString(6,reservation.getCustomer_id());
            pstm.setString(7, reservation.getStart_time());
            pstm.setString(8, reservation.getEnd_time());
            pstm.setString(9,reservation.getEvent());
            pstm.setString(10, reservation.getReservationId());

            return pstm.executeUpdate() > 0;
        }

    }
    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM reservation WHERE reservation_id= ?";
        try (PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql)) {
            pstm.setString(1, id);
            return pstm.executeUpdate() > 0;

        }
    }

    public static List<Reservation> getAll() throws SQLException {
        String sql = "SELECT * FROM reservation";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Reservation> bookingList = new ArrayList<>();

        while (resultSet.next()) {
            String ReservationID = resultSet.getString(1);
            Date doR=resultSet.getDate(2);
            Date Rdate=resultSet.getDate(3);
            Time Rtime=resultSet.getTime(4);
            String empID  = resultSet.getString(5);
            String tableID = resultSet.getString(6);
            String cusID = resultSet.getString(7);
            String startTime = resultSet.getString(8);
            String endTime = resultSet.getString(9);
            String event = resultSet.getString(10);

            Reservation reservation= new Reservation(ReservationID,doR,Rdate,Rtime,empID,tableID,cusID,startTime,endTime,event);

            bookingList.add(reservation);
        }
        return bookingList;
    }


    public static Reservation searchById(String id) throws SQLException {
        String sql = "SELECT * FROM reservation WHERE reservation_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String ReservationID = resultSet.getString(1);
            Date doR=resultSet.getDate(2);
            Date Rdate=resultSet.getDate(3);
            Time Rtime=resultSet.getTime(4);
            String empID  = resultSet.getString(5);
            String tableID = resultSet.getString(6);
            String cusID = resultSet.getString(7);
            String startTime = resultSet.getString(8);
            String endTime = resultSet.getString(9);
            String event = resultSet.getString(10);

            Reservation reservation= new Reservation(ReservationID,doR,Rdate,Rtime,empID,tableID,cusID,startTime,endTime,event);

            return reservation;
        }

        return null;
    }
}
