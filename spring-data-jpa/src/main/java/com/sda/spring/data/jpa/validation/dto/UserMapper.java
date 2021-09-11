package com.sda.spring.data.jpa.validation.dto;

import com.sda.spring.data.jpa.validation.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<User> toEntity(List<UserWriteDto> dtos) {
        return dtos.stream()
                .map(userReadDto -> toEntity(userReadDto))
                .collect(Collectors.toList());
    }

    public List<UserReadDto> toDto(List<User> users) {
        return users.stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());
    }

    public User toEntity(UserWriteDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setConsented(dto.isConsented());
        user.setAboutMe(dto.getAboutMe());
        user.setAge(dto.getAge());
        return user;
    }

    public User toEntity(User userToUpdate, UserWriteDto updateInfo) {
        userToUpdate.setName(updateInfo.getName());
        userToUpdate.setEmail(updateInfo.getEmail());
        userToUpdate.setConsented(updateInfo.isConsented());
        userToUpdate.setAboutMe(updateInfo.getAboutMe());
        userToUpdate.setAge(updateInfo.getAge());
        return userToUpdate;
    }

    public UserReadDto toDto(User user) {
        UserReadDto dto = new UserReadDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setConsented(user.isConsented());
        dto.setAboutMe(user.getAboutMe());
        dto.setAge(user.getAge());
        return dto;
    }
}
