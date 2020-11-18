package com.dbproject.recipe.security.service.impl;

import com.dbproject.recipe.exception.ServiceException;
import com.dbproject.recipe.exception.constant.ErrorCodeEnum;
import com.dbproject.recipe.security.dto.InformationDto;
import com.dbproject.recipe.security.repository.UserRepository;
import com.dbproject.recipe.security.repository.entity.QUser;
import com.dbproject.recipe.security.repository.entity.User;
import com.dbproject.recipe.security.service.InformationService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InformationServiceInfo implements InformationService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<InformationDto> updateInfo(final Principal principal,
                                                     final InformationDto informationDto) {
        final User user = userRepository.findOne(QUser.user.email.eq(principal.getName()))
                .orElseThrow(() -> new
                        ServiceException(ErrorCodeEnum.ENTITY_FOUND,"User not found"));

        User updatedUser = updateInfo(user,informationDto);

        final InformationDto info = modelMapper.map(updatedUser,InformationDto.class);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
    private User updateInfo(final User user, final InformationDto informationDto){
        User updatedUser = modelMapper.map(informationDto,User.class);

        updatedUser.setId(user.getId());
        updatedUser.setRoles(user.getRoles());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setDateCreated(user.getDateCreated());
        updatedUser.setLastUpdated(updatedUser.getLastUpdated());

        updatedUser = userRepository.save(updatedUser);

        return updatedUser;


    }
}
