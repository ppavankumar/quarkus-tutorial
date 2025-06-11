package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import net.datafaker.Faker;
import org.example.models.dto.EmployeeDTO;
import org.example.models.entities.Employee;
import org.example.models.mapper.EmployeeMapper;
import org.example.models.payload.EmployeePayload;
import org.example.repositories.EmployeeRepository;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class EmployeeService {
    @Inject
    private EmployeeRepository employeeRepository;

    @Transactional
    public String seedUsers(Integer numOfUsers) {
        if (Objects.isNull(numOfUsers)) {
            return "Please provide a number of users to be seeded!";
        }
        Faker faker = new Faker();
        Employee employee;
        for (int i = 0; i < numOfUsers; i++) {
            employee = new Employee();
            employee.setFirstName(faker.name().fullName());
            employeeRepository.persist(employee);
        }
        return String.format("Inserted %d fake users!", numOfUsers);
    }

    public List<EmployeeDTO> listAll() {
        List<Employee> users = employeeRepository.listAll();
        return EmployeeMapper.INSTANCE.toEmployeeDTOList(users);
    }

    @Transactional
    public void save(EmployeePayload payload) {
        employeeRepository.persist(
                EmployeeMapper.INSTANCE.toEmployee(payload)
        );
    }
}
