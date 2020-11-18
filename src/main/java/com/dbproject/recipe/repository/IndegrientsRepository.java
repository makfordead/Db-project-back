package com.dbproject.recipe.repository;

import com.dbproject.recipe.repository.entity.Indegrients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface IndegrientsRepository extends JpaRepository<Indegrients,String>, QuerydslPredicateExecutor<Indegrients> {
}
