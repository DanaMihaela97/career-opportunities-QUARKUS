package com.career.opportunities.service;

import com.career.opportunities.entity.User;
import io.smallrye.mutiny.Uni;

public interface UserService {
    Uni<User> createUser(User user);
}
