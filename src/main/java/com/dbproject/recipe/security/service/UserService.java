package com.dbproject.recipe.security.service;


import com.dbproject.recipe.security.dto.SignUpRequest;

public interface  UserService {

    void save(final SignUpRequest request);
}
