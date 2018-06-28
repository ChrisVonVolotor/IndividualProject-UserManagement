package com.individual.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
      /*
        List<UserCreation> users = new ArrayList<>();

        users.add(new UserCreation("Bob", "Ross"));
        users.add(new UserCreation("Carl", "Sagan"));
        users.add(new UserCreation("Mike", "Vienna"));
        users.add(new UserCreation("Wayne", "Kerr"));
        userRepository.saveAll(users);
*/
    }

    /*@Override
    public void run(String... args) throws Exception {
        List<UserCreation> users = new ArrayList<>();

        users.add(new UserCreation("Bob", "Ross"));
        users.add(new UserCreation("Carl", "Sagan"));
        users.add(new UserCreation("Mike", "Vienna"));
        users.add(new UserCreation("Wayne", "Kerr"));
        userRepository.saveAll(users);
    }*/

}

