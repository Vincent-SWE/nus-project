package nus.miniproject.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentsComplete {
    
    private Customer customer;
    private Outlets outlets;
    private Date appointmentsDate;



}
