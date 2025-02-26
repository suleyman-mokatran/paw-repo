package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    public AppUser findByEmail(String email);

    public AppUser findByFirstNameAndLastName(String firstName, String lastName);

    public AppUser findByRole(String role);

    public AppUser save(AppUser appUser);

    public AppUser delete(int userId);

}


