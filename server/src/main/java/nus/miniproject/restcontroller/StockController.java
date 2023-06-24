package nus.miniproject.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nus.miniproject.model.Stock;
import nus.miniproject.service.StockService;


@RestController
public class StockController {

    @Autowired
    private StockService stockService;


    // GET all blood stock
    @GetMapping("/stock")
    public ResponseEntity<String> getAllBloodStock(@RequestBody String request) {
        String response = stockService.getAllBloodStock(request);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    // GET blood stock by id
    @GetMapping("/stock/{stock-id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("stock-id") Integer id) {
        Stock stock = stockService.findById(id);

        if (stock == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(stock);
    }





    


}
