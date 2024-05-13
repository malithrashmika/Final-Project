package lk.Ijse.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    String code;
    String name;
    String description;
    String type;
    double price;
    int QtyOnHand;
}
