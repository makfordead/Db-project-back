package com.dbproject.recipe.repository.entity;

import com.dbproject.recipe.repository.entity.Indegrients;
import com.dbproject.recipe.security.repository.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "recipes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recipe {
    @Id
    @Column(name = "recipe_id")
    String id = UUID.randomUUID().toString().replace("-", "");

    String name;
    @Lob
    String image;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Indegrients> indegrients;

    @OneToOne
    User user;

    String method;

}
