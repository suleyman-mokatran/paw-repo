package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.Models.ProductProvider;
import com.PAWCOMPANY.paw.Models.ServiceProvider;
import com.PAWCOMPANY.paw.Repositories.ProductProviderRepository;
import com.PAWCOMPANY.paw.Repositories.ServiceProviderRepository;
import com.PAWCOMPANY.paw.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductProviderService {

    @Autowired
    ProductProviderRepository productProviderRepository;

    public ProductProvider addNewProductProvider(ProductProvider productProvider){
        productProvider.setRole(Role.PP);
        return productProviderRepository.save(productProvider);
    }

    public void deleteProductProvider(int productProviderId){
        productProviderRepository.deleteById(productProviderId);
    }

    public List<ProductProvider> findAllProductProvidersByCompanyId(int companyId){
        return productProviderRepository.findProductProviderByCompany(companyId);
    }

    public ProductProvider updateProductProvider(int ppId, ProductProvider pp) {
        Optional<ProductProvider> existingPp = productProviderRepository.findById(ppId);

        if (existingPp.isEmpty()) {
            throw new RuntimeException("PP with ID " + ppId + " not found.");
        }

        ProductProvider PPToUpdate = existingPp.get();

        PPToUpdate.setFirstname(pp.getFirstname());
        PPToUpdate.setLastname(pp.getLastname());
        PPToUpdate.setBirthDate(pp.getBirthDate());
        PPToUpdate.setGender(pp.getGender());
        PPToUpdate.setEmail(pp.getEmail());
        PPToUpdate.setPassword(pp.getPassword());
        PPToUpdate.setPhone(pp.getPhone());
        PPToUpdate.setAddress(pp.getAddress());

        return productProviderRepository.save(PPToUpdate);
    }
    public  Optional<ProductProvider> getPPById(int ppId) {
        return productProviderRepository.findById(ppId)
                ;
    }


    public List<ProductProvider> getAllProductProviders(){
        return productProviderRepository.findByRole(Role.PP);
    }
}
