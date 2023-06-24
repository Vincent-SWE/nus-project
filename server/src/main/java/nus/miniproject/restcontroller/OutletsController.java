package nus.miniproject.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nus.miniproject.model.Outlets;
import nus.miniproject.service.OutletsService;

@RestController
public class OutletsController {
    
    @Autowired
    private OutletsService outletsService;
    

    // GET all outlets
    @GetMapping("/outlets")
    public ResponseEntity<String> findAllOutlets(@RequestBody String request) {
        String response = outletsService.findAllOutlets(request);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    // GET outlets by id
    @GetMapping("/outlets/{outlets-id}")
    public ResponseEntity<Outlets> findOutletsById(@PathVariable("outlets-id") Integer id) {
        Outlets outlets = outletsService.findOutletsByIdOutlets(id);

        if (outlets == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(outlets);
    }







}
