package com.bnelson.starter.repository;

import com.bnelson.starter.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, UUID> {

    @Query()
    Optional<UserEntity> findByEmail(String email);

    @Query("update UserEntity e set e.password = :password where e.uuid = :uuid")
    @Modifying
    void updatePasswordHash(UUID uuid, String password);

}
