package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.DTO.AppUserDTO;
import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Repositories.AppUserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository, ModelMapper modelMapper) {
        this.appUserRepository = appUserRepository;
        this.modelMapper = modelMapper;
    }

    public AppUserDTO createUser(AppUserDTO appUserDTO) {
        AppUser appUser = modelMapper.map(appUserDTO, AppUser.class);
        appUser = appUserRepository.save(appUser);
        return modelMapper.map(appUser, AppUserDTO.class);
    }

    public AppUserDTO getUserById(int id) {
        AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(appUser, AppUserDTO.class);
    }

    public List<AppUserDTO> getAllUsers() {
        List<AppUser> users = appUserRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, AppUserDTO.class))
                .collect(Collectors.toList());
    }

    public AppUserDTO updateUser(int id, AppUserDTO appUserDTO) {
        AppUser existingUser = appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setFirstname(appUserDTO.getFirstname());
        existingUser.setLastname(appUserDTO.getLastname());
        existingUser.setEmail(appUserDTO.getEmail());
        existingUser.setPhone(appUserDTO.getPhone());
        existingUser.setAddress(appUserDTO.getAddress());

        AppUser updatedUser = appUserRepository.save(existingUser);
        return modelMapper.map(updatedUser, AppUserDTO.class);
    }

    public void deleteUser(int id) {
        if (!appUserRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        appUserRepository.deleteById(id);
    }
}
