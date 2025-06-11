package org.example.models.entities.id_classes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeID {
    private Long id;

    private String department;

    public String firstName;

    public String lastName;
}
