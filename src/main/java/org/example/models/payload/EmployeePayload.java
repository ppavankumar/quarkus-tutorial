package org.example.models.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayload {
    private String firstName;

    private String lastName;

    private String department;

    private String active = "N";

    private LocalDateTime joinedDate = LocalDateTime.now();
}
