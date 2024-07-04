package lk.Ijse.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    String code;
    String name;
    String description;
    String category;
    double price;
    int QtyOnHand;
}
