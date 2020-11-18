package com.dbproject.recipe.service;

import com.dbproject.recipe.dto.AllRecipesResponse;
import com.dbproject.recipe.dto.RecipeRequest;
import com.dbproject.recipe.dto.RecipeResponse;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;

public interface RecipeService {
    ResponseEntity<RecipeResponse> createRecipe(RecipeRequest recipeRequest, Principal principal);

    ResponseEntity<AllRecipesResponse> getAllRecipes(Principal principal);
}
