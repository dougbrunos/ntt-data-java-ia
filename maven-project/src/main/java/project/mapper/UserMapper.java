package project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import project.dto.UserDTO;
import project.model.UserModel;

@Mapper
public interface UserMapper {
    @Mapping(target = "code", source = "id") // Assuming 'id' in UserDTO maps to 'code' in UserModel
    @Mapping(target = "userName", source = "name") // Assuming 'name' in UserDTO maps to 'userName' in UserModel
    UserModel toModel(UserDTO dto);

    @Mapping(target = "id", source = "code") // Assuming 'code' in UserModel maps to 'id' in UserDTO
    @Mapping(target = "name", source = "userName") // Assuming 'userName' in UserModel maps to 'name' in UserDTO
    UserDTO toDTO(UserModel model);
}
