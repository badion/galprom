package com.galprom.repository;

import com.galprom.model.Grid;
import com.galprom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Badion on 23.05.2016.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
