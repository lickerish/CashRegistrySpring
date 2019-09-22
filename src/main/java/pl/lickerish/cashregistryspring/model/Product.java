package pl.lickerish.cashregistryspring.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "productNumber")
    private String productNumber;
    @Column(name = "price")
    private Double price;
}
