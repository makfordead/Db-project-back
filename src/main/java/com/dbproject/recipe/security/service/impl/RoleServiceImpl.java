package com.dbproject.recipe.security.service.impl;


import com.dbproject.recipe.exception.ServiceException;
import com.dbproject.recipe.exception.constant.ErrorCodeEnum;
import com.dbproject.recipe.security.repository.RoleRepository;
import com.dbproject.recipe.security.repository.entity.QRole;
import com.dbproject.recipe.security.repository.entity.Role;
import com.dbproject.recipe.security.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {


    RoleRepository roleRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Role save(final String name) {
        Role role = new Role();
        role.setName(name.toUpperCase());
        if (roleRepository.findOne(QRole.role.name.eq(role.getName())).isPresent()) {
            throw new ServiceException(ErrorCodeEnum.ENTITY_FOUND, "Role already exist with this name");
        }
        return roleRepository.save(role);
    }
}
