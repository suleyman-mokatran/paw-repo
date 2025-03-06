package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.Models.Category;
import com.PAWCOMPANY.paw.Models.Product;
import com.PAWCOMPANY.paw.Repositories.CategoryRepository;
import com.PAWCOMPANY.paw.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category addNewPetCategory(Category category, String categoryName){
        category.setType(Type.PET);
        category.setName(categoryName);
        return categoryRepository.save(category);
    }

    public Category addNewProductCategory(Category category, String categoryName) {
        category.setType(Type.PRODUCT);  // Set the category type to PRODUCT
        category.setName(categoryName);  // Set the name of the category
        return categoryRepository.save(category);  // Save the category to the database
    }




    public Category updateCategory(int id, String categoryName) {
        Optional<Category> existingCategory = categoryRepository.findById(id);

        if (existingCategory.isEmpty()) {
            throw new RuntimeException("Category not found");
        }

        Category categoryToUpdate = existingCategory.get();

        categoryToUpdate.setName(categoryName);

        return categoryRepository.save(categoryToUpdate);
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

    public Optional<Category> findById( int CategoryId){
        return categoryRepository.findById(CategoryId);
}
    

}
