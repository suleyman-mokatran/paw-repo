package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.ProductProvider;
import com.PAWCOMPANY.paw.Models.ServiceProvider;
import com.PAWCOMPANY.paw.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductProviderRepository extends JpaRepository<ProductProvider,Integer> {

    @Query(value = "SELECT * FROM Product_Provider WHERE company_id = :companyId", nativeQuery = true)
    List<ProductProvider> findProductProviderByCompany(@Param("companyId") int companyId);

    List<ProductProvider> findByRole(Role role);
}
