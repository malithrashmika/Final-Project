package lk.Ijse.model;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Events {
    String event_id;
    String name;
    String description;
    Date date;
    String start_time;
    String end_time;
}
