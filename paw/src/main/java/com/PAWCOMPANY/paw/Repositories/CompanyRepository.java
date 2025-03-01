package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
