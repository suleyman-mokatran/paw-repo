package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.Appointment;
import com.PAWCOMPANY.paw.Models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceModel,Integer> {


    @Query(value = "SELECT * FROM Services WHERE price = :price", nativeQuery = true)
    List<ServiceModel> findServicesByPrice(@Param("price") float price);

    @Query(value = "SELECT * FROM Services WHERE company_id = :companyId", nativeQuery = true)
    List<ServiceModel> findServicesByCompany(@Param("companyId") int companyId);
}
