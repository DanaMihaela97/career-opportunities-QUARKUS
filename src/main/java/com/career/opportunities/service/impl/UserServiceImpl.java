package com.career.opportunities.service.impl;

import com.career.opportunities.entity.User;
import com.career.opportunities.repository.UserRepository;
import com.career.opportunities.service.UserService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository userRepository;

    @Override
    public Uni<User> createUser(User user) {
        return Uni.createFrom().item(()->{
            userRepository.persist(user);
            return user;
        });
    }
}
