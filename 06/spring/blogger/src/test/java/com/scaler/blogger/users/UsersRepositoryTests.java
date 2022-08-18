package com.scaler.blogger.users;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UsersRepositoryTests {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    @Order(1)
    void can_create_users() {
//        usersRepository.save(
//                UserEntity.builder()
//                        .username("johndoe123")
//                        .email("john@mail.com")
//                        .build()
//        );
    }

    @Test
    @Order(2)
    void can_find_users_by_username() {
//        usersRepository.save(
//                UserEntity.builder()
//                        .username("johndoe123")
//                        .email("john@mail.com")
//                        .build()
//        );
//        var user = usersRepository.findByUsername("johndoe123")
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        assertEquals(user.getUsername(), "johndoe123");

    }

}
