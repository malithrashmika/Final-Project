package lk.Ijse.model.tm;

import com.jfoenix.controls.JFXButton;

import java.sql.Date;
import java.sql.Time;

public class OrderTm {
    private String orderId;
    private String ItemId;
    private String orderDes;
    private Double orderPrice;
    private String tableType;
    private Date orderDate;
    private Time orderTime;
    private String waiter;
    private int quantity;
    private double netTotal;
    private JFXButton btnRemove;
}
