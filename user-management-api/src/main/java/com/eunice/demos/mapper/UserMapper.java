package com.eunice.demos.mapper;

import com.eunice.demos.dto.response.UserResponseDTO;
import com.eunice.demos.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO userToUserResponseDTO(User user);

    List<UserResponseDTO> userToUserResponseDTOs(List<User> users);
}
