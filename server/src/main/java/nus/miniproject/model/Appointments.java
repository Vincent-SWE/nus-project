package nus.miniproject.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointments {
    
    private Integer id;
    private Integer customerId;
    private Integer outletsId;
    private Date appointmentsDate;
    
}
