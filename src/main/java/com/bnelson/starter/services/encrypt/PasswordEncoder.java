package com.bnelson.starter.services.encrypt;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class PasswordEncoder {
    public static final Base64.Encoder ENCODER = Base64.getEncoder();

    public String encode(String password) {
        // TODO this is not actually encrypting passwords.
        return ENCODER.encodeToString(password.getBytes());
    }

}
