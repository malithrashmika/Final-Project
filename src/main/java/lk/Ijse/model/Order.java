package lk.Ijse.model;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String orderId;
    private String customerId;
    private Date orderDate;
    private String orderTime;
    private String Table;
    private String employeeId;


}
