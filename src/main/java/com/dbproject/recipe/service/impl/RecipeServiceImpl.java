package com.dbproject.recipe.service.impl;

import com.dbproject.recipe.dto.AllRecipesResponse;
import com.dbproject.recipe.dto.RecipeRequest;
import com.dbproject.recipe.dto.RecipeResponse;
import com.dbproject.recipe.exception.ServiceException;
import com.dbproject.recipe.exception.constant.ErrorCodeEnum;
import com.dbproject.recipe.repository.IndegrientsRepository;
import com.dbproject.recipe.repository.RecipeRepository;
import com.dbproject.recipe.repository.entity.QRecipe;
import com.dbproject.recipe.repository.entity.Recipe;
import com.dbproject.recipe.security.repository.UserRepository;
import com.dbproject.recipe.security.repository.entity.QUser;
import com.dbproject.recipe.security.repository.entity.User;
import com.dbproject.recipe.service.RecipeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    IndegrientsRepository indegrientsRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<RecipeResponse> createRecipe(final RecipeRequest recipeRequest
    , final Principal principal) {
        Recipe recipe = modelMapper.map(recipeRequest,Recipe.class);

        final User user = userRepository.findOne(QUser.user.email.eq(principal.getName()))
                .orElseThrow(() -> new ServiceException(ErrorCodeEnum.ENTITY_NOT_FOUND,"User not found"));

        recipe.setUser(user);

        recipe = recipeRepository.save(recipe);
        final RecipeResponse dto = modelMapper.map(recipe, RecipeResponse.class);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AllRecipesResponse> getAllRecipes(final Principal principal) {

        final Iterable<Recipe> recipes = recipeRepository.findAll(
                QRecipe.recipe.user.email.eq(principal.getName()));

        final List<RecipeResponse> recipeResponses = new ArrayList<>();

        for(final Recipe recipe : recipes){
            recipeResponses.add(modelMapper.map(recipe,RecipeResponse.class));
        }

        final AllRecipesResponse allRecipesResponse = new AllRecipesResponse();
        allRecipesResponse.setList(recipeResponses);
        return new ResponseEntity<>(allRecipesResponse,HttpStatus.OK);
    }
}
