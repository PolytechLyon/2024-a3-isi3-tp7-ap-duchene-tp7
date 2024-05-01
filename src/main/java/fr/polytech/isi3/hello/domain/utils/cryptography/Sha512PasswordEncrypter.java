package fr.polytech.isi3.hello.domain.utils.cryptography;

import fr.polytech.isi3.hello.domain.utils.cryptography.PasswordEncrypter;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class Sha512PasswordEncrypter implements PasswordEncrypter {
    @Override
    public String encrypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return new String(hashedPassword, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to encrypt password", e);
        }
    }
}