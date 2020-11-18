package com.dbproject.recipe.security.repository;

import com.dbproject.recipe.security.repository.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends PagingAndSortingRepository<User, String>, QuerydslPredicateExecutor<User> {



    @Query("SELECT u FROM User u WHERE u.email = :email")
    public Optional<User> findByUsername(@Param("email") String username);



}
