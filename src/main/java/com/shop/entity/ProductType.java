package com.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * Тип продукта
 */
@Entity
@Table
@Getter
@Setter
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String nameCategory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productType")
    private Set<Product> products;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productType")
    @JsonIgnore
    private Set<ProductFeature> productFeatures;


    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
