package nus.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.miniproject.model.AppointmentsComplete;
import nus.miniproject.repository.AppointmentsRepository;

@Service
public class AppointmentsService {
    
    @Autowired
    private AppointmentsRepository appointmentsRepository;


    public String findAllAppointments(String request) {
        return appointmentsRepository.findAllAppointments().toString();
    }


    public List<AppointmentsComplete> findAllAppointmentsRS(String request) {
        return appointmentsRepository.findAllAppointmentsRS();
    }

    public AppointmentsComplete findAppointmentsById(Integer id) {
    return appointmentsRepository.findAppointmentsById(id);
}

}
