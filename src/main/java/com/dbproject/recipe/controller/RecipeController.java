package com.dbproject.recipe.controller;

import com.dbproject.recipe.dto.AllRecipesResponse;
import com.dbproject.recipe.dto.RecipeRequest;
import com.dbproject.recipe.dto.RecipeResponse;
import com.dbproject.recipe.service.RecipeService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recipe")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @PostMapping("/create")
    public ResponseEntity<RecipeResponse> createRecipe(@RequestBody final RecipeRequest recipeRequest,
                                                       final Principal principal){

        return recipeService.createRecipe(recipeRequest,principal);
    }
    @GetMapping("/all")
    public ResponseEntity<AllRecipesResponse> getAllRecipes(Principal principal){
        return recipeService.getAllRecipes(principal);
    }
}
