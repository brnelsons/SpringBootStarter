package com.bnelson.starter.domain.convert;

import com.bnelson.starter.domain.model.User;
import com.bnelson.starter.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements BiConverter<User, UserEntity>{

    @Override
    public UserEntity convertInternal(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(user.getUuid());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        return userEntity;
    }

    @Override
    public User reverseInternal(UserEntity userEntity) {
        return new User(
                userEntity.getUuid(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail());
    }
}
