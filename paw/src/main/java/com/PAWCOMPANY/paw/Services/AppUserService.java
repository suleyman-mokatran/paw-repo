package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser appUser = repo.findByEmail(email);

        if(appUser != null){
            var springUser = User.withUsername(appUser.getEmail())
                    .password(appUser.getPassword())
                    .roles(appUser.getRole())
                    .build();

            return springUser;
        }

        return null;
    }

    public List<AppUser> findAllUsers(){
        return repo.findAll();
    }

    public AppUser findUsersByFirstNameAndLastName(String firstName , String lastName){
        return repo.findByFirstNameAndLastName(firstName,lastName);
    }

    public AppUser findByRole(String role){
        return repo.findByRole(role);
    }

    public AppUser createNewUser(AppUser appUser){
        return repo.save(appUser);
    }

    public AppUser deleteUserById(int id){
        return repo.delete(id);
    }


}