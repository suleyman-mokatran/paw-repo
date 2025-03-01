package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.Models.Doctor;
import com.PAWCOMPANY.paw.Repositories.DoctorRepository;
import com.PAWCOMPANY.paw.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public Doctor addNewDoctor(Doctor doctor){
        doctor.setRole(Role.DOCTOR);
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(int doctorId, Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorRepository.findById(doctorId);

        if (existingDoctor.isEmpty()) {
            throw new RuntimeException("Doctor with ID " + doctorId + " not found.");
        }

        Doctor doctorToUpdate = existingDoctor.get();

        doctorToUpdate.setFirstname(doctor.getFirstname());
        doctorToUpdate.setLastname(doctor.getLastname());
        doctorToUpdate.setBirthDate(doctor.getBirthDate());
        doctorToUpdate.setGender(doctor.getGender());
        doctorToUpdate.setEmail(doctor.getEmail());
        doctorToUpdate.setPassword(doctor.getPassword());
        doctorToUpdate.setPhone(doctor.getPhone());
        doctorToUpdate.setAddress(doctor.getAddress());
        doctorToUpdate.setSpecialization(doctor.getSpecialization());
        doctorToUpdate.setAvailability(doctor.getAvailability());
        doctorToUpdate.setExperienceYears(doctor.getExperienceYears());

        return doctorRepository.save(doctorToUpdate);
    }

    public void deleteDoctor(int doctorId){
        doctorRepository.deleteById(doctorId);
    }
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public Optional<Doctor> findById(int doctorId){
        return doctorRepository.findById(doctorId);
    }

    public List<Doctor> findDoctorsByAvailability(Doctor doctor){
        return doctorRepository.findDoctorByAvailability(Boolean.parseBoolean(doctor.getAvailability()));
    }

    public List<Doctor> findDoctorsBySpecialization(Doctor doctor){
        return doctorRepository.findDoctorBySpecialization(doctor.getSpecialization());
    }
}
