package full.stack.employee_management_backend.dto;
/*
* We use this class to transfer the data between client and server
* DTO stands for data transfer object. As the name suggests, a DTO is an object made to transfer data.
*  Data Access Object (or DAO)
* DAO has CRUD actions like save, update, and remove. DTO is just a thing that stores information.
* */



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
