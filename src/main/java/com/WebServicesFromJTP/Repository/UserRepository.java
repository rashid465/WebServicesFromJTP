package com.WebServicesFromJTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WebServicesFromJTP.Bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
