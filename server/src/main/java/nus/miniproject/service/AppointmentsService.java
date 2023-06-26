package nus.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.miniproject.model.Appointments;
import nus.miniproject.model.AppointmentsComplete;
import nus.miniproject.model.Customer;
import nus.miniproject.repository.AppointmentsRepository;
import nus.miniproject.repository.CustomerRepository;

@Service
public class AppointmentsService {
    
    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public String findAllAppointments(String request) {
        return appointmentsRepository.findAllAppointments().toString();
    }


    public List<AppointmentsComplete> findAllAppointmentsRS(String request) {
        return appointmentsRepository.findAllAppointmentsRS();
    }

    public AppointmentsComplete findAppointmentsById(Integer id) {
        return appointmentsRepository.findAppointmentsById(id);
    }


    public Boolean insertAppointments(Appointments appointments) {
        return appointmentsRepository.insertAppointments(appointments);
    }


    public Boolean insertAppointments2(AppointmentsComplete appointmentsComplete) {
        Customer customer = appointmentsComplete.getCustomer();
        Boolean insertCustomer = customerRepository.insertCustomer(customer);
        if (insertCustomer) {
            Customer customerLatest = customerRepository.findCustomerLatest();
            Appointments appointments = new Appointments();
            appointments.setCustomerId(customerLatest.getId());
            appointments.setOutletsId(appointmentsComplete.getOutlets().getId());
            appointments.setAppointmentsDate(appointmentsComplete.getAppointmentsDate());

            return appointmentsRepository.insertAppointments(appointments);
        }
        else {
        return false;
        }
    }


    public int deleteAppointmentsById(Integer id) {
        return appointmentsRepository.deleteAppointmentsById(id);
    }

    





}
