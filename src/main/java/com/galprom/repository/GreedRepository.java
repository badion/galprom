package com.galprom.repository;

import com.galprom.model.Greed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreedRepository extends JpaRepository<Greed,Long> {

}