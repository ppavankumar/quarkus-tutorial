package org.example.controllers;

import net.datafaker.Faker;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.entities.User;
import org.example.repositories.UserRepository;

import java.util.List;
import java.util.Objects;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GET
    public List<User> getAllUsers() {
        return userRepository.listAll();
    }

    @POST
    public void addUser(User user) {
        userRepository.persist(user);
    }

    @GET
    @Path("/seed/{numOfUsers}")
    @Transactional
    public String seedUsers(
            @PathParam("numOfUsers") Integer numOfUsers
    ) {
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

//    @POST
//    @Path("/seed/")
//    @Transactional
//    public String seedUsers() {
//        Faker faker = new Faker();
//        User user;
//        for (int i = 0; i < 10; i++) {
//            user = new User();
//            user.setName(faker.name().fullName());
//            userRepository.persist(user);
//        }
//        return String.format("Inserted %d fake users!", 10);
//    }
}
