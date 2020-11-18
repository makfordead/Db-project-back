package com.dbproject.recipe.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PACKAGE)
public class AllRecipesResponse {
    List<RecipeResponse> list;
}
