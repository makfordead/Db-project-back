package com.dbproject.recipe.security.service;


import com.dbproject.recipe.security.repository.entity.Role;

public interface RoleService {

    Role save(final String name);
}
