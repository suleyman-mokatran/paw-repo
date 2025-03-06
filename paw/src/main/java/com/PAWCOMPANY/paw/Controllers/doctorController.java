package com.PAWCOMPANY.paw.Controllers;


import com.PAWCOMPANY.paw.Models.Appointment;
import com.PAWCOMPANY.paw.Models.Doctor;
import com.PAWCOMPANY.paw.Models.Product;
import com.PAWCOMPANY.paw.Repositories.AppointmentRepository;
import com.PAWCOMPANY.paw.Services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/doctor")
public class doctorController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/addappointment")
    public ResponseEntity<?> addNewAppointment( @RequestBody Appointment appointment) {

        Appointment savedAppointment = appointmentService.addNewAppointment(appointment);

        return ResponseEntity.ok(savedAppointment);
    }
    @PutMapping("/updateappointment/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable int id,@Valid @RequestBody Appointment appointment){

        Appointment savedAppointment = appointmentService.updateAppointment(id,appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/getallappointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/getappointment/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable int id) {
        return appointmentService.getAppointment(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found"));
    }



    @DeleteMapping("/deleteappointment/{id}")
    public void deleteAppointment(@PathVariable int id ){
        appointmentService.DeleteAppointment(id);
    }
}
