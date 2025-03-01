package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Models.Doctor;
import com.PAWCOMPANY.paw.Models.ServiceProvider;
import com.PAWCOMPANY.paw.Repositories.ServiceProviderRepository;
import com.PAWCOMPANY.paw.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService {

    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    public ServiceProvider addNewServiceProvider(ServiceProvider serviceProvider){
        serviceProvider.setRole(Role.SP);
        return serviceProviderRepository.save(serviceProvider);
    }

    public void deleteServiceProvider(int serviceProviderId){
        serviceProviderRepository.deleteById(serviceProviderId);
    }

    public List<ServiceProvider> findAllServiceProvidersByCompanyId(int companyId){
        return serviceProviderRepository.findServiceProviderByCompany(companyId);
    }

    public ServiceProvider updateServiceProvider(int spId, ServiceProvider sp) {
        Optional<ServiceProvider> existingSp = serviceProviderRepository.findById(spId);

        if (existingSp.isEmpty()) {
            throw new RuntimeException("SP with ID " + spId + " not found.");
        }

        ServiceProvider SPToUpdate = existingSp.get();

        SPToUpdate.setFirstname(sp.getFirstname());
        SPToUpdate.setLastname(sp.getLastname());
        SPToUpdate.setBirthDate(sp.getBirthDate());
        SPToUpdate.setGender(sp.getGender());
        SPToUpdate.setEmail(sp.getEmail());
        SPToUpdate.setPassword(sp.getPassword());
        SPToUpdate.setPhone(sp.getPhone());
        SPToUpdate.setAddress(sp.getAddress());
        SPToUpdate.setCompany(sp.getCompany());

        return serviceProviderRepository.save(SPToUpdate);
    }


    public List<ServiceProvider> getAllServiceProviders(){
        return serviceProviderRepository.findByRole(Role.SP);
    }
}
