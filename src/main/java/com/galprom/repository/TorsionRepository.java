package com.galprom.repository;

import com.galprom.model.Torsion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorsionRepository extends JpaRepository<Torsion,Long> {

}