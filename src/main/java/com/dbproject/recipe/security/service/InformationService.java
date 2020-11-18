package com.dbproject.recipe.security.service;


import com.dbproject.recipe.security.dto.InformationDto;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

public interface InformationService {

    public ResponseEntity<InformationDto> updateInfo(Principal principal,
                                                     InformationDto informationDto);
}
