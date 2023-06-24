package nus.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.miniproject.Exception.ResourceNotFoundException;
import nus.miniproject.model.Outlets;
import nus.miniproject.repository.OutletsRepository;

@Service
public class OutletsService {
    
    @Autowired
    private OutletsRepository outletsRepository;

    public String findAllOutlets(String request) {
        return outletsRepository.findAllOutlets().toString();
    }

    
    public Outlets findOutletsByIdOutlets(Integer id) throws ResourceNotFoundException {
        Outlets outlets = outletsRepository.findOutletsById(id);
        return outlets;
    }


    
}
