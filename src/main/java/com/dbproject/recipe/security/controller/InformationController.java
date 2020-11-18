package com.dbproject.recipe.security.controller;

import com.dbproject.recipe.security.dto.InformationDto;
import com.dbproject.recipe.security.service.InformationService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/update-info")
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin
public class InformationController {

    @Autowired
    InformationService informationService;

    @PutMapping
    public ResponseEntity<InformationDto> updateInformation(Principal principal,
                                                            @RequestBody InformationDto informationDto){
        return informationService.updateInfo(principal,informationDto);
    }
}
