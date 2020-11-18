package com.dbproject.recipe.repository;

import com.dbproject.recipe.repository.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RecipeRepository extends JpaRepository<Recipe,String>, QuerydslPredicateExecutor<Recipe> {
}
