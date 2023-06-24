package nus.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Outlets {
    
    private Integer id;
    private String buildingName;
    private String address;

    
}
