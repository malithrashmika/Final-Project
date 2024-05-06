package lk.Ijse.model;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String orderId;
    private Date orderDate;
    private String orderStatus;
    private String orderTime;
    private String customerId;
    private String employeeId;

}
