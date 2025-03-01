package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.Models.Category;
import com.PAWCOMPANY.paw.Repositories.CategoryRepository;
import com.PAWCOMPANY.paw.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category addNewPetCategory(Category category){
        category.setType(Type.PET);
        return categoryRepository.save(category);
    }

    public Category addNewProductCategory(Category category){
        category.setType(Type.PRODUCT);
        return categoryRepository.save(category);
    }

    public void deleteCategory(int CategoryId){
        categoryRepository.deleteById(CategoryId);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public List<Category> findPetCategory(){
        return categoryRepository.findByType(Type.PET);
    }

    public List<Category> findProductCategory(){
        return categoryRepository.findByType(Type.PRODUCT);
    }

    

}
