package com.PAWCOMPANY.paw.Controllers;

import com.PAWCOMPANY.paw.Models.*;
import com.PAWCOMPANY.paw.Repositories.CategoryRepository;
import com.PAWCOMPANY.paw.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DoctorService doctorService;


    @PostMapping("/adddoctor")
    public ResponseEntity<?> addNewDoctor(@Valid @RequestBody Doctor doctor, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Doctor savedDoctor = doctorService.addNewDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }
    @PutMapping("/updatedoctor/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable int id,@Valid @RequestBody Doctor doctor, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Doctor savedDoctor = doctorService.updateDoctor(id,doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @DeleteMapping("/deletedoctor/{id}")
    public void deleteDoctor(@PathVariable int id ){
        doctorService.deleteDoctor(id);
    }

    @GetMapping("/getdoctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @Autowired
    AdminService adminService;

    @PostMapping("/addadmin")
    public ResponseEntity<?> addNewAdmin(@Valid @RequestBody AppUser admin, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        AppUser savedAdmin = adminService.addNewAdmin(admin);
        return ResponseEntity.ok(savedAdmin);
    }
    @PutMapping("/updateadmin/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable int id,@Valid @RequestBody AppUser admin, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        AppUser savedAdmin = adminService.updateAdmin(id,admin);
        return ResponseEntity.ok(savedAdmin);
    }

    @DeleteMapping("/deleteadmin/{id}")
    public void deleteAdmin(@PathVariable int id ){
        adminService.deleteAdmin(id);
    }

    @GetMapping("/getadmins")
    public List<AppUser> getAllAdmins() {
        return adminService.getAllAdmins();
    }

   @Autowired
   CategoryService categoryService;

    @PostMapping("/addpetcategory")
    public ResponseEntity<?> addNewPetCategory(@Valid @RequestBody Category category, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Category savedCategory = categoryService.addNewPetCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @PostMapping("/addproductcategory")
    public ResponseEntity<?> addNewProductCategory(@Valid @RequestBody Category category, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Category savedCategory = categoryService.addNewProductCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/getcategories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/deletecategory/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

    @Autowired
    AppUserService appUserService;

    @PostMapping("/adduser")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody AppUser user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        AppUser savedUser = appUserService.addNewUser(user);
        return ResponseEntity.ok(savedUser);
    }
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,@Valid @RequestBody AppUser user, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        AppUser savedUser = appUserService.updateUser(id,user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable int id ){
        appUserService.deleteUser(id);
    }

    @GetMapping("/getallusers")
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @Autowired
    ServiceProviderService serviceProviderService;

    @PostMapping("/addsp")
    public ResponseEntity<?> addNewSP(@Valid @RequestBody ServiceProvider sp, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        ServiceProvider savedsp = serviceProviderService.addNewServiceProvider(sp);
        return ResponseEntity.ok(savedsp);
    }
    @PutMapping("/updatesp/{id}")
    public ResponseEntity<?> updateSP(@PathVariable int id,@Valid @RequestBody ServiceProvider sp, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        ServiceProvider savedsp = serviceProviderService.updateServiceProvider(id,sp);
        return ResponseEntity.ok(savedsp);
    }

    @DeleteMapping("/deletesp/{id}")
    public void deleteSP(@PathVariable int id ){
        serviceProviderService.deleteServiceProvider(id);
    }

    @GetMapping("/getallsp")
    public List<ServiceProvider> getAllSP() {
        return serviceProviderService.getAllServiceProviders();
    }

    @Autowired
    ProductProviderService productProviderService;

    @PostMapping("/addpp")
    public ResponseEntity<?> addNewPP(@Valid @RequestBody ProductProvider pp, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        ProductProvider savedpp = productProviderService.addNewProductProvider(pp);
        return ResponseEntity.ok(savedpp);
    }
    @PutMapping("/updatepp/{id}")
    public ResponseEntity<?> updatePP(@PathVariable int id,@Valid @RequestBody ProductProvider pp, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        ProductProvider savedpp = productProviderService.updateProductProvider(id,pp);
        return ResponseEntity.ok(savedpp);
    }

    @DeleteMapping("/deletepp/{id}")
    public void deletePP(@PathVariable int id ){
        productProviderService.deleteProductProvider(id);
    }

    @GetMapping("/getallpp")
    public List<ProductProvider> getAllPP() {
        return productProviderService.getAllProductProviders();
    }

    @Autowired
    CompanyService companyService;

    @PostMapping("/addcompany")
    public ResponseEntity<?> addNewCompany(@Valid @RequestBody Company company ,BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Company savedCompany = companyService.addNewCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    @PutMapping("/updatecompany/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable int id,@Valid @RequestBody Company company, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Company savedCompany = companyService.updateCompany(id,company);
        return ResponseEntity.ok(savedCompany);
    }

    @DeleteMapping("/deletecompany/{id}")
    public void deleteCompany(@PathVariable int id ){
        companyService.deleteCompany(id);
    }

    @GetMapping("/getallcompanies")
    public List<Company> getAllCompanies() {
        return companyService.findAllCompanies();
    }


}
