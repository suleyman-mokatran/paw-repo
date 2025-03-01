package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Models.Appointment;
import com.PAWCOMPANY.paw.Models.Doctor;
import com.PAWCOMPANY.paw.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<AppUser, Integer> {

    List<AppUser> findByRole(Role role);



}
