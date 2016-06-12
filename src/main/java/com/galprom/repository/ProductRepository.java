package com.galprom.repository;

import com.galprom.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Badion on 23.05.2016.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    public List<Product> findProductsByFromClass(String nama);

}
