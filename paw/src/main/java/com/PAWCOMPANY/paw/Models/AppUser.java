package com.PAWCOMPANY.paw.Models;
import com.PAWCOMPANY.paw.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.*;
import java.lang.annotation.Inherited;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity

@Table(name = "appusers")
@Inheritance (strategy =  InheritanceType.JOINED)
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int AppUserId;

    String firstname;
    String lastname;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    String gender;

    @Column (unique = false,nullable = true)
    String email;
    @Column (unique = false,nullable = true)
    int phone;

    @Enumerated(EnumType.STRING)
    private Role role;
    String address;
    String password;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Pet> petList;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Pet> AdoptedPets;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CartId", referencedColumnName = "CartId")
    private Cart cart;

    public int getAppUserId() {
        return AppUserId;
    }

    public void setAppUserId(int appUserId) {
        AppUserId = appUserId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public List<Pet> getAdoptedPets() {
        return AdoptedPets;
    }

    public void setAdoptedPets(List<Pet> adoptedPets) {
        AdoptedPets = adoptedPets;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
