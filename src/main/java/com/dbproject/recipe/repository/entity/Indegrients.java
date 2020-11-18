package com.dbproject.recipe.repository.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Indegrients {
    @Id
    String id = UUID.randomUUID().toString().replace("-","");

    String name;
}
