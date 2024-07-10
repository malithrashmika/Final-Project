package lk.Ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaceOrder implements Serializable {
    private Order orderDTO;
    private List<order_item> odList;
}
