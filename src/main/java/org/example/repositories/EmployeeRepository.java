package org.example.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.models.entities.Employee;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {
}
