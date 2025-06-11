package org.example.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.models.converter.BooleanToStringConverter;
import org.example.models.entities.id_classes.EmployeeID;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 * <p>
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 * <p>
 * Usage (more example on the documentation)
 * <p>
 * {@code
 * public void doSomething() {
 * MyEntity entity1 = new MyEntity();
 * entity1.field = "field-1";
 * entity1.persist();
 * <p>
 * List<MyEntity> entities = MyEntity.listAll();
 * }
 * }
 */

@Table(name = "employee_tbl")
@Entity
@Data
@IdClass(EmployeeID.class)
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column
    public String department;

    @Convert(converter = BooleanToStringConverter.class)
    public Boolean active = false;

    @Column(name = "date_of_joining")
    private LocalDateTime joinedDate;
}
