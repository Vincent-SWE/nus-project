package nus.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.miniproject.Exception.ResourceNotFoundException;
import nus.miniproject.model.Stock;
import nus.miniproject.repository.StockRepository;

@Service
public class StockService {
    

    @Autowired
    private StockRepository stockRepository;

    public String getAllBloodStock(String request) {
        return stockRepository.findAll().toString();
    }


    public Stock findById(Integer id) throws ResourceNotFoundException {
        Stock stock = stockRepository.findById(id);

        return stock;
    }



    
    // Testing if my stock works with hardcoded values
    //     if (request.equals("A")) {
    //         Stock test =  new Stock();
    //         test.setId(1);
    //         test.setBloodType("A");
    //         test.setAmount(80);
    //         return test.toString();
    //     }
    //     else if (request.equals("B")) {
    //         Stock test =  new Stock();
    //         test.setId(2);
    //         test.setBloodType("B");
    //         test.setAmount(70);
    //         return test.toString();
    //     }
    //     else if (request.equals("AB")) {
    //         Stock test =  new Stock();
    //         test.setId(3);
    //         test.setBloodType("AB");
    //         test.setAmount(60);
    //         return test.toString();
    //     } 
    //     else if (request.equals("O")) {
    //         Stock test =  new Stock();
    //         test.setId(4);
    //         test.setBloodType("O");
    //         test.setAmount(50);
    //         return test.toString();
    //     }
    //     else {
    //         return "Invalid blood type";
    //     }
    // }


}
