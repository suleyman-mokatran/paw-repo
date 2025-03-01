package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.AppUser;
import com.PAWCOMPANY.paw.Models.Appointment;
import com.PAWCOMPANY.paw.Models.Category;
import com.PAWCOMPANY.paw.Role;
import com.PAWCOMPANY.paw.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    List<Category> findByType(Type type);
}
