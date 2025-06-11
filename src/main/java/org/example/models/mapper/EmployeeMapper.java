package org.example.models.mapper;

import org.example.models.dto.EmployeeDTO;
import org.example.models.entities.Employee;
import org.example.models.payload.EmployeePayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
        /*(
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)*/
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    //    @Mapping(
//            expression = "java(source.getFirstName() + \" \" + source.getLastName())",
//            target = "fullName"
//    )
    @Mapping(
            source = ".",
            target = "fullName"
    )
    EmployeeDTO toEmployeeDTO(Employee source);

    Employee toEmployee(EmployeePayload source);

    List<EmployeeDTO> toEmployeeDTOList(List<Employee> source);

    default String getFullName(Employee source) {
        return source.getFirstName() + " " + source.getLastName();
    }
}
