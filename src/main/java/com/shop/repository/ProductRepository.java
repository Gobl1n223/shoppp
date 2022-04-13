package com.shop.repository;

import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.entity.ValueProductFeature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  //  List<Product> findByValueProductCharacteristicIn(Iterable<ValueProductFeature> valueCharacteristics);

  //    Product findByProductTypeOrderByName(Product productType);
  @Query(value = "select p from Product p left join p.valueProductFeature where p.name = :name")
  Set<Product> findByName(@Param("name") String name);

  @Query(value = "select p from Product p inner join p.productType where p.productType.nameCategory = :category order by p.price")
  List<Product> findProductsByCategory(@Param("category") String category, Pageable page);

}
