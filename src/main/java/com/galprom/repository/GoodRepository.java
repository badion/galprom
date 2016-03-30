package com.galprom.repository;

import com.galprom.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good,Long> {

}