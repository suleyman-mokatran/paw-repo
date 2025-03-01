package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "SELECT * FROM Appointment WHERE doctor_id = :doctorId", nativeQuery = true)
    List<Appointment> findAppointmentsByDoctor(@Param("doctorId") int doctorId);

    @Query(value = "SELECT * FROM Appointment WHERE service_id = :serviceId", nativeQuery = true)
    List<Appointment> findAppointmentsByService(@Param("serviceId") int serviceId);

    @Query(value = "SELECT * FROM Appointment WHERE price = :price", nativeQuery = true)
    List<Appointment> findAppointmentsByPrice(@Param("price") float price);

    @Query(value = "SELECT * FROM Appointment WHERE status = :status", nativeQuery = true)
    List<Appointment> findAppointmentsByStatus(@Param("status") String status);
}
