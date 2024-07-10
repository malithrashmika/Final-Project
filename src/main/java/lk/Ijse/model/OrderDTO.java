package lk.Ijse.model;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements Serializable {
    private String orderId;
    private String customerId;
    private Date orderDate;
    private Time time;
    private String Table;
    private String employeeId;
    private double NetTotal;


}
