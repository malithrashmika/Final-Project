package lk.Ijse.model;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    String reservationId;
    Date date_of_reservation;
    Date reserved_date;
    String reserved_time;
    String employee_id;
    String table_Number;
}
