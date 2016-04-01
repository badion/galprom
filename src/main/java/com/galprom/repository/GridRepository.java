package com.galprom.repository;

import com.galprom.model.Grid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridRepository extends JpaRepository<Grid,Long> {

}