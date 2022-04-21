package com.axonactive.venko.service.impl;

import com.axonactive.venko.controller.request.AuthRequest;
import com.axonactive.venko.entity.User;
import com.axonactive.venko.service.AuthService;
import com.axonactive.venko.util.HashUtil;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@RequestScoped
public class AuthServiceImpl implements AuthService {

    @PersistenceContext(unitName = "venko")
    private EntityManager entityManager;

    @Override
    public boolean login(AuthRequest userRequest) {
        TypedQuery<User> query = entityManager.createQuery("FROM User u WHERE u.username = :username and u.password =:password", User.class);
        query.setParameter("username", userRequest.getUsername());
        query.setParameter("password", HashUtil.hashTextMD5(userRequest.getPassword()));
        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e){
            throw new WebApplicationException(Response.status(400).entity("Username and password incorrect").build());
        }

    }
}
