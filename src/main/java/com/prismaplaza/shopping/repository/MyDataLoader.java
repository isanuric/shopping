package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public MyDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("john.doe@example.com", "password1");
        userRepository.save(user);
    }
}
