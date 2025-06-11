package org.example.controllers;

import jakarta.inject.Inject;
import net.datafaker.Faker;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.dto.UserDTO;
import org.example.models.entities.User;
import org.example.models.mapper.UserMapper;
import org.example.repositories.UserRepository;
import org.example.service.UserService;

import java.util.List;
import java.util.Objects;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    private UserService userService;

    @GET
    public List<UserDTO> getAllUsers() {
        return userService.listAll();
    }

    @POST
    public void addUser(User user) {
        userService.save(user);
    }

    @GET
    @Path("/seed/{numOfUsers}")
    @Transactional
    public String seedUsers(
            @PathParam("numOfUsers") Integer numOfUsers
    ) {
        return userService.seedUsers(numOfUsers);
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
