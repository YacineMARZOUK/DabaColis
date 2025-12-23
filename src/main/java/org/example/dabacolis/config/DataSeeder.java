package org.example.dabacolis.config;

import org.example.dabacolis.entity.User;
import org.example.dabacolis.enums.UserRole;
import org.example.dabacolis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .login("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role(UserRole.ADMIN)
                    .active(true)
                    .build();

            userRepository.save(admin);
            System.out.println("------ DEFAULT ADMIN CREATED ------");
            System.out.println("Login: admin");
            System.out.println("Password: admin123");
        }
    }
}