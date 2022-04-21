package com.axonactive.venko.mapper;

import com.axonactive.venko.controller.request.UserRequest;
import com.axonactive.venko.entity.User;
import com.axonactive.venko.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toEntity(UserRequest userRequest);
    UserDTO toDTO(User user);
}
