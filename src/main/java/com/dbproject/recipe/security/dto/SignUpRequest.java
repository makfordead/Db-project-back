package com.dbproject.recipe.security.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpRequest {

    @NotEmpty
    String email;

    String name;

    String surname;

    String address;

    @NotEmpty
    String password;

    List<Long> roles;

}
