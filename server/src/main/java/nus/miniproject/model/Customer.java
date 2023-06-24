package nus.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    // firstName (Entity) --> first_name (MySQL)
    // firstname (Entity) --> firstname (MySQL)
    // I used first_name and last_name in MySQL, so my Java entity would be firstName and lastName

    private Integer id;
    private String firstName;
    private String lastName;
    
    

}
