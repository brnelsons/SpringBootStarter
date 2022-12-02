package com.bnelson.starter.api;

import com.bnelson.starter.domain.model.User;
import com.bnelson.starter.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(UUID uuid, User user) {
        return userService.updateUser(uuid, user);
    }

    @Override
    public ResponseEntity<Void> updateUser(UUID uuid) {
        userService.deleteUser(uuid);
        return ResponseEntity.ok().build();
    }
}
