package com.prismaplaza.shopping.entity;

import com.prismaplaza.shopping.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserTest {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("test_abcd")
                    .withUsername("user_abcd")
                    .withPassword("password_abcd");

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("test@test.com", savedUser.getEmail());
        assertEquals("password", savedUser.getPassword());
    }

    @Test
    public void getUserById() {
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("password");
        userRepository.save(user);

        User foundUser = userRepository.findById(user.getId()).get();
        assertNotNull(foundUser);
        assertEquals(user.getEmail(), foundUser.getEmail());
        assertEquals(user.getPassword(), foundUser.getPassword());
    }

    @Test
    public void updateUser() {
        User oldUser = new User();
        oldUser.setEmail("user@gmail.com");
        oldUser.setPassword("password");
        userRepository.save(oldUser);

        User updatedUser = new User();
        updatedUser.setId(oldUser.getId());
        updatedUser.setEmail("updated@example.com");
        updatedUser.setPassword("newpassword");
        userRepository.save(updatedUser);

        User foundUser = userRepository.findById(oldUser.getId()).get();
        assertNotNull(foundUser);
        assertEquals(updatedUser.getEmail(), foundUser.getEmail());
        assertEquals(updatedUser.getPassword(), foundUser.getPassword());
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("password");
        userRepository.save(user);

        userRepository.delete(user);
        List<User> users = userRepository.findAll();
        assertTrue(users.isEmpty());
    }

}