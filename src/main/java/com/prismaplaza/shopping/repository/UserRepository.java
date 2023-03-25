package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>  {

}
