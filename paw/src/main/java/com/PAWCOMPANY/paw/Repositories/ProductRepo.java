package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
