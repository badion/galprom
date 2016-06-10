package com.galprom.repository;

import com.galprom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Home on 10.06.2016.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findUserByUserNameAndPassword(String name, String password);
}
