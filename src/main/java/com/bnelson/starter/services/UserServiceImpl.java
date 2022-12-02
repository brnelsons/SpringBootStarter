package com.bnelson.starter.services;

import com.bnelson.starter.domain.convert.UserConverter;
import com.bnelson.starter.domain.model.User;
import com.bnelson.starter.repository.UserRepository;
import com.bnelson.starter.repository.entity.UserEntity;
import com.bnelson.starter.services.encrypt.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           UserConverter userConverter,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Iterable<User> getUsers() {
        return userConverter.reverseAll(userRepository.findAll());
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = userConverter.convert(user);
        if (entity.getUuid() == null) {
            entity.setUuid(UUID.randomUUID());
        }
        return userConverter.reverse(userRepository.save(entity));
    }

    @Override
    public User updateUser(UUID uuid, User user) {
        UserEntity entity = userConverter.convert(user);
        entity.setUuid(uuid);
        return userConverter.reverse(userRepository.save(entity));
    }

    @Override
    public void deleteUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    @Override
    public boolean checkLogin(String email, String passwordHash) {
        return userRepository.findByEmail(email)
                .map(foundUser -> passwordHash.equals(passwordEncoder.encode(foundUser.getPassword())))
                .orElse(false);
    }

    @Override
    public void updatePassword(UUID uuid, String password) {
        // TODO validate password is secure or throw an exception.
        userRepository.updatePasswordHash(uuid, passwordEncoder.encode(password));
    }
}
