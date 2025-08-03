package project;

import java.time.LocalDate;

import org.mapstruct.factory.Mappers;

import project.dto.UserDTO;
import project.mapper.UserMapper;
import project.model.UserModel;

public class Main {

    private static UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {
        var model = new UserModel();
        model.setCode(1);
        model.setUserName("James");
        model.setBirthday(LocalDate.now().minusYears(25));
        System.out.println(mapper.toDTO(model));

        var dto = new UserDTO();
        dto.setId(1);
        dto.setName("John Doe");
        dto.setBirthday(LocalDate.now().minusYears(30));
        System.out.println(mapper.toModel(dto));
    }
}