package project.mapper;

import javax.annotation.processing.Generated;
import project.dto.UserDTO;
import project.model.UserModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T14:43:39-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel toModel(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setCode( dto.getId() );
        userModel.setUserName( dto.getName() );
        userModel.setBirthday( dto.getBirthday() );

        return userModel;
    }

    @Override
    public UserDTO toDTO(UserModel model) {
        if ( model == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( model.getCode() );
        userDTO.setName( model.getUserName() );
        userDTO.setBirthday( model.getBirthday() );

        return userDTO;
    }
}
