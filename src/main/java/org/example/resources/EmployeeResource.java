package org.example.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.dto.EmployeeDTO;
import org.example.models.payload.EmployeePayload;
import org.example.service.EmployeeService;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    @Inject
    private EmployeeService employeeService;

    @GET
    public RestResponse<List<EmployeeDTO>> getAllUsers() {
        return RestResponse.ResponseBuilder.ok(
                        employeeService.listAll()
                )
                .header("X-Custom-Header", "some-value")
                .build();
    }

    @POST
    public RestResponse<String> addUser(EmployeePayload user) {
        employeeService.save(user);
        return RestResponse.ok(
                "saved user successfully"
        );
    }

    @GET
    @Path("/seed/{numOfUsers}")
    @Transactional
    public String seedUsers(
            @PathParam("numOfUsers") Integer numOfUsers
    ) {
        return employeeService.seedUsers(numOfUsers);
    }

//    @POST
//    @Path("/seed/")
//    @Transactional
//    public String seedUsers() {
//        Faker faker = new Faker();
//        Employee user;
//        for (int i = 0; i < 10; i++) {
//            user = new Employee();
//            user.setName(faker.name().fullName());
//            userRepository.persist(user);
//        }
//        return String.format("Inserted %d fake users!", 10);
//    }
}
