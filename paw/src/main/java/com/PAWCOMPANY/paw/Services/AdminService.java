package com.PAWCOMPANY.paw.Services;


import com.PAWCOMPANY.paw.DTO.AppUserDTO;
import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Models.Appointment;
import com.PAWCOMPANY.paw.Models.Doctor;
import com.PAWCOMPANY.paw.Repositories.AdminRepository;
import com.PAWCOMPANY.paw.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AppUser addNewAdmin(AppUser appUser){
        appUser.setRole(Role.ADMIN);
        return adminRepository.save(appUser);
    }

    public void deleteAdmin(int adminId){
        adminRepository.deleteById(adminId);
    }

    public AppUser updateAdmin(int adminId, AppUser admin) {
        Optional<AppUser> existingAdmin = adminRepository.findById(adminId);

        if (existingAdmin.isEmpty()) {
            throw new RuntimeException("Admin with ID " + adminId + " not found.");
        }

        AppUser adminToUpdate = existingAdmin.get();

        adminToUpdate.setFirstname(admin.getFirstname());
        adminToUpdate.setLastname(admin.getLastname());
        adminToUpdate.setBirthDate(admin.getBirthDate());
        adminToUpdate.setGender(admin.getGender());
        adminToUpdate.setEmail(admin.getEmail());
        adminToUpdate.setPassword(admin.getPassword());
        adminToUpdate.setPhone(admin.getPhone());
        adminToUpdate.setAddress(admin.getAddress());

        return adminRepository.save(adminToUpdate);
    }

    public List<AppUser> getAllAdmins(){
        return adminRepository.findByRole(Role.ADMIN);
    }




}
