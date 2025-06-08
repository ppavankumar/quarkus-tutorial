package org.example.models.mapper;

import org.example.models.dto.UserDTO;
import org.example.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
        /*(
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)*/
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "fullName")
    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOList(List<User> user);
}
