package lk.Ijse.model.tm;

import lk.Ijse.repository.EmployeeRepo;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class EmployeeTm extends EmployeeRepo {
    private String id;
    private String name;
    private String tel;
    private String salary;
    private String Role;
}
