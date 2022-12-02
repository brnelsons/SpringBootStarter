package com.bnelson.starter.api;

import com.bnelson.starter.domain.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/users")
public interface UserController {

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<User> getUsers();

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    User createUser(@RequestBody User user);

    @PutMapping(
            path = "/{userUuid}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    User updateUser(@PathVariable("userUuid") UUID uuid,
                    @RequestBody User user);

    @DeleteMapping("/{userUuid}")
    ResponseEntity<Void> updateUser(@PathVariable("userUuid") UUID uuid);

}
