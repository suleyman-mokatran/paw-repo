package com.PAWCOMPANY.paw.Controllers;

import com.PAWCOMPANY.paw.Models.Doctor;
import com.PAWCOMPANY.paw.Models.Pet;
import com.PAWCOMPANY.paw.Models.Product;
import com.PAWCOMPANY.paw.Repositories.PetRepository;
import com.PAWCOMPANY.paw.Services.DoctorService;
import com.PAWCOMPANY.paw.Services.PetService;
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
@RequestMapping("/user")
public class AppController {

   @Autowired
    PetService petService;

    @PostMapping("/addpet")
    public ResponseEntity<?> addNewPet( @RequestBody Pet pet) {

         petService.addNewPet(pet);
        return ResponseEntity.ok(pet);
    }
    @PutMapping("/updatepet/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable int id,@RequestBody Pet pet){

        Pet savedPet = petService.updatePet(id,pet);
        return ResponseEntity.ok(savedPet);
    }

    @DeleteMapping("/deletepet/{id}")
    public void deletePet(@PathVariable int id ){
        petService.deletePet(id);
    }


    @GetMapping("/getallpets")
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/getpet/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable int id) {
        return petService.getPetById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found"));
    }
}
