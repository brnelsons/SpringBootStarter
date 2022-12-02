package com.bnelson.starter.domain.model;

import com.google.common.base.Objects;

import java.util.UUID;

public class User {
    private final UUID uuid;
    private final String firstName;
    private final String lastName;
    private final String email;

    public User(UUID uuid, String firstName, String lastName, String email) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(uuid, user.uuid)
                && Objects.equal(firstName, user.firstName)
                && Objects.equal(lastName, user.lastName)
                && Objects.equal(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid, firstName, lastName, email);
    }
}
