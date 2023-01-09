package cloud.project.mapper;

import cloud.project.dto.UserDTO;
import cloud.project.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToDTO (User user);
    User dtoToUser (UserDTO dto);
}