package com.galprom.repository;

import com.galprom.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    public List<SubCategory> findSubcategoriesByCategoryId(Long categoryId);

}
