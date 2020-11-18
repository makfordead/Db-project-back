package com.dbproject.recipe.controller;

import com.dbproject.recipe.dto.AllRecipesResponse;
import com.dbproject.recipe.dto.RecipeResponse;
import com.dbproject.recipe.repository.RecipeRepository;
import com.dbproject.recipe.repository.entity.Recipe;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unregistered/recipe/all")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnregisteredRecipeController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    RecipeRepository recipeRepository;
    @GetMapping
    public ResponseEntity<AllRecipesResponse> getAllRecipes(){
        final List<Recipe> recipeList = recipeRepository.findAll();

        List<RecipeResponse> recipeResponses = recipeList.stream().map(
                r -> modelMapper.map(r,RecipeResponse.class)
        ).collect(Collectors.toList());

        final AllRecipesResponse allRecipesResponse = new AllRecipesResponse();

        allRecipesResponse.setList(recipeResponses);
        return new ResponseEntity<>(allRecipesResponse, HttpStatus.OK);

    }
}
