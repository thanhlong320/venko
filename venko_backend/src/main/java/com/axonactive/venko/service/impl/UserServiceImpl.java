package com.axonactive.venko.service.impl;

import com.axonactive.venko.controller.request.UserRequest;
import com.axonactive.venko.entity.User;
import com.axonactive.venko.mapper.UserMapper;
import com.axonactive.venko.service.UserService;
import com.axonactive.venko.service.dto.UserDTO;
import com.axonactive.venko.util.HashUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext(name = "venko")
    private EntityManager entityManager;

    @Inject
    private UserMapper userMapper;

    @Override
    public UserDTO register(UserRequest userRequest) {
        userRequest.setPassword(HashUtil.hashTextMD5(userRequest.getPassword()));
        User user = userMapper.toEntity(userRequest);
        entityManager.persist(user);
        return userMapper.toDTO(user);
    }
}
