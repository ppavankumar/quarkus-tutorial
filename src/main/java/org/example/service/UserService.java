package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import net.datafaker.Faker;
import org.example.models.dto.UserDTO;
import org.example.models.entities.User;
import org.example.models.mapper.UserMapper;
import org.example.repositories.UserRepository;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;

    @Transactional
    public String seedUsers(Integer numOfUsers) {
        if (Objects.isNull(numOfUsers)) {
            return "Please provide a number of users to be seeded!";
        }
        Faker faker = new Faker();
        User user;
        for (int i = 0; i < numOfUsers; i++) {
            user = new User();
            user.setName(faker.name().fullName());
            userRepository.persist(user);
        }
        return String.format("Inserted %d fake users!", numOfUsers);
    }

    public List<UserDTO> listAll() {
        List<User> users = userRepository.listAll();
        return UserMapper.INSTANCE.toUserDTOList(users);
    }

    public void save(User user) {
        userRepository.persist(user);
    }
}
