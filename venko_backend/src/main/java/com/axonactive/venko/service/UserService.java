package com.axonactive.venko.service;

import com.axonactive.venko.controller.request.UserRequest;
import com.axonactive.venko.service.dto.UserDTO;

public interface UserService {
    UserDTO register(UserRequest userRequest);
}
