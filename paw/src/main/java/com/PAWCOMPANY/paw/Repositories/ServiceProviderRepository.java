package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Models.Appointment;
import com.PAWCOMPANY.paw.Models.ServiceProvider;
import com.PAWCOMPANY.paw.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Integer> {

    @Query(value = "SELECT * FROM Service_Provider WHERE company_id = :companyId", nativeQuery = true)
    List<ServiceProvider> findServiceProviderByCompany(@Param("companyId") int companyId);

    List<ServiceProvider> findByRole(Role role);
}
