package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


@Service
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
   @Query(value = "select * from users where userName = :userName", nativeQuery = true)
   User findUserByName(@Param("userName") String username);

}
