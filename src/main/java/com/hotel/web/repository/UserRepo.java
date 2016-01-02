package com.hotel.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.web.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("Select u.id from User u where u.username= :username and u.password = :password")
	String getUser(@Param("username") String username, @Param("password") String password);
}
