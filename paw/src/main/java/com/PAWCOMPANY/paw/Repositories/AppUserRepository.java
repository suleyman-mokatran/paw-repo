package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    List<AppUser> findByRole(Role role);
}


