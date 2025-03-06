package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reviews")

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ReviewId;
    String Rating;
    String Comment;
    Date date;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "appUser")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "Service")
    private ServiceModel Service;


}
