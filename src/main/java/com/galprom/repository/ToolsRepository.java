package com.galprom.repository;

import com.galprom.model.SubCategory;
import com.galprom.model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Long> {

}
