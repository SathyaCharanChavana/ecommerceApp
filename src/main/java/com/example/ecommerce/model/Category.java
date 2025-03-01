package com.example.ecommerce.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
