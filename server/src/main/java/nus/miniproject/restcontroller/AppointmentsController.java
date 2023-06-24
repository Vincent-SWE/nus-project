package nus.miniproject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nus.miniproject.model.AppointmentsComplete;
import nus.miniproject.model.Outlets;
import nus.miniproject.service.AppointmentsService;

@RestController
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;
    
    // GET all appointments
    @GetMapping("/appointments")
    public ResponseEntity<String> findAllAppointments(@RequestBody String request) {
        String response = appointmentsService.findAllAppointments(request);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/appointmentsRS")
    public ResponseEntity<List<AppointmentsComplete>> findAllAppointmentsRS(@RequestBody String request) {
        List<AppointmentsComplete> response = appointmentsService.findAllAppointmentsRS(request);
        return new ResponseEntity<List<AppointmentsComplete>>(response, HttpStatus.OK);
    }

       // GET outlets by id
    @GetMapping("/appointments/{appointments-id}")
    public ResponseEntity<AppointmentsComplete> findOutletsById(@PathVariable("appointments-id") Integer id) {
        AppointmentsComplete apptcplt = appointmentsService.findAppointmentsById(id);

        if (apptcplt == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(apptcplt);
    }



}
