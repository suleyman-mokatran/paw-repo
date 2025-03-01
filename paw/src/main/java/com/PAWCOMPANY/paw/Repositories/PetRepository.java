package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.Appointment;
import com.PAWCOMPANY.paw.Models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Integer> {

    @Query(value = "SELECT * FROM pets WHERE gender = :gender", nativeQuery = true)
    List<Pet> findPetByGender(@Param("gender") String gender);

    @Query(value = "SELECT * FROM pets WHERE status = :status", nativeQuery = true)
    List<Pet> findPetByStatus(@Param("status") String status);

}
