package com.dbproject.recipe.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecipeRequest {
    List<IndegrientRequest> indegrients;
    String name;
    String image;
    String method;
}
