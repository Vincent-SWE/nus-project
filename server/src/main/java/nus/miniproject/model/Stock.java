package nus.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    
    private Integer id;
    private String bloodType;
    private Integer amount;
    
    
}
