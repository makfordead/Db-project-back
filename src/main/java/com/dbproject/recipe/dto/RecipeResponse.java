package com.dbproject.recipe.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecipeResponse {
    String id;

    String name;

    List<IndegrientResponse> indegrients;
    String image;
    String method;
}
