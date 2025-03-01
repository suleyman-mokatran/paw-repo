package com.PAWCOMPANY.paw.Controllers;

import com.PAWCOMPANY.paw.Models.Doctor;
import com.PAWCOMPANY.paw.Models.ServiceModel;
import com.PAWCOMPANY.paw.Services.ServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sp")
public class spController {

    @Autowired
    ServiceService serviceService;

    @PostMapping("/addservice")
    public ResponseEntity<?> addNewService(@Valid @RequestBody ServiceModel service, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        ServiceModel savedService = serviceService.addNewService(service);
        return ResponseEntity.ok(savedService);
    }
    @PutMapping("/updateservice/{id}")
    public ResponseEntity<?> updateService(@PathVariable int id,@Valid @RequestBody ServiceModel service, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        ServiceModel savedService = serviceService.updateService(id,service);
        return ResponseEntity.ok(savedService);
    }

    @DeleteMapping("/deleteservice/{id}")
    public void deleteService(@PathVariable int id ){
        serviceService.deleteService(id);
    }
}
