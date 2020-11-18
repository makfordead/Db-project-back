package com.dbproject.recipe.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Id;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IndegrientResponse {
    String id;

    String name;
}
