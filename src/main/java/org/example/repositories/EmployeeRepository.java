package org.example.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.models.entities.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
