package com.bnelson.starter.services;

import com.bnelson.starter.domain.model.User;

import java.util.UUID;

public interface UserService {
    Iterable<User> getUsers();

    User createUser(User user);

    User updateUser(UUID uuid, User user);

    void deleteUser(UUID uuid);

    boolean checkLogin(String email, String passwordHash);

    void updatePassword(UUID uuid, String password);
}
