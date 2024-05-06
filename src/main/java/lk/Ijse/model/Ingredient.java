package lk.Ijse.model;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {
    String Ingredient_id;
    String Ingredient_name;
    String category;
    String qty_avalible;
    String unit_price;
    String supplier_id;
}
