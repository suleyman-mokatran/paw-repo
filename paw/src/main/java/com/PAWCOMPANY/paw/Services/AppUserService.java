package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Repositories.AdminRepository;
import com.PAWCOMPANY.paw.Repositories.AppUserRepository;
import com.PAWCOMPANY.paw.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService{

    @Autowired
    AppUserRepository appUserRepository;

    public AppUser addNewUser(AppUser appUser){
        appUser.setRole(Role.USER);
        return appUserRepository.save(appUser);
    }

    public void deleteUser(int userId){
        appUserRepository.deleteById(userId);
    }

    public AppUser updateUser(int userId, AppUser user) {
        Optional<AppUser> existingUser = appUserRepository.findById(userId);

        if (existingUser.isEmpty()) {
            throw new RuntimeException("Doctor with ID " + userId + " not found.");
        }

        AppUser userToUpdate = existingUser.get();

        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setBirthDate(user.getBirthDate());
        userToUpdate.setGender(user.getGender());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setAddress(user.getAddress());

        return appUserRepository.save(userToUpdate);
    }

    public List<AppUser> getAllUsers(){
        return appUserRepository.findByRole(Role.USER);
    }

}