package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.Appointment;
import com.PAWCOMPANY.paw.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query(value = "SELECT * FROM doctor WHERE availability = :availability", nativeQuery = true)
    List<Doctor> findDoctorByAvailability(@Param("availability") boolean availability);

    @Query(value = "SELECT * FROM doctor WHERE specialization = :specialization", nativeQuery = true)
    List<Doctor> findDoctorBySpecialization(@Param("specialization") String specialization);
}
