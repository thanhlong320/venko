package com.axonactive.venko.service;

import com.axonactive.venko.controller.request.AuthRequest;

public interface AuthService {
    boolean login(AuthRequest userRequest);
}
