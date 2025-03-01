package com.PAWCOMPANY.paw.Controllers;

import com.PAWCOMPANY.paw.Models.Doctor;
import com.PAWCOMPANY.paw.Models.Pet;
import com.PAWCOMPANY.paw.Repositories.PetRepository;
import com.PAWCOMPANY.paw.Services.DoctorService;
import com.PAWCOMPANY.paw.Services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AppController {

   @Autowired
    PetService petService;

    @PostMapping("/addpet")
    public ResponseEntity<?> addNewPet(@Valid @RequestBody Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Pet savedPet = petService.addNewPet(pet);
        return ResponseEntity.ok(savedPet);
    }
    @PutMapping("/updatepet/{id}")
    public ResponseEntity<?> updatePet(@PathVariable int id,@Valid @RequestBody Pet pet, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Pet savedPet = petService.updatePet(id,pet);
        return ResponseEntity.ok(savedPet);
    }

    @DeleteMapping("/deletepet/{id}")
    public void deletePet(@PathVariable int id ){
        petService.deletePet(id);
    }
}
