package com.example.ecommerce.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    //TODO:Check the Cascade Type
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders;
}
