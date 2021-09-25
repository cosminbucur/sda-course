package com.sda.spring.data.jpa.validation;

import com.sda.spring.data.jpa.validation.dto.UserMapper;
import com.sda.spring.data.jpa.validation.dto.UserReadDto;
import com.sda.spring.data.jpa.validation.dto.UserWriteDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// validate service or controller, persistence layer validation is too late
// evaluate the constraint annotations on method parameters
@Validated
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public final UserRepository userRepository;
    public final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // expecting this object to be valid
    public UserReadDto save(@Valid UserWriteDto writeDto) {
        log.info("saving user: {}", writeDto);

        User entity = userMapper.toEntity(writeDto);
        User savedEntity = userRepository.save(entity);
        return userMapper.toDto(savedEntity);
    }

    public List<UserReadDto> findAll() {
        log.info("find all users");

        return userRepository.findAll().stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());
    }

    public UserReadDto findById(Long id) {
        log.info("finding user: {}", id);

        return userRepository.findById(id)
                .map(user -> userMapper.toDto(user))
                .orElseThrow(() -> new NotFoundException("user not found"));
    }

    public UserReadDto update(Long id, UserWriteDto updateData) {
        return userRepository.findById(id)
                .map(user -> userMapper.toEntity(user, updateData))
                .map(updatedUser -> userRepository.save(updatedUser))
                .map(savedUser -> userMapper.toDto(savedUser))
                .orElseThrow(() -> new NotFoundException("user not found"));
    }

    public UserReadDto updateOld(Long id, UserWriteDto dto) {
        // find user
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user with id " + id + " not found "));

        // change data
        foundUser.setName(dto.getName());
        foundUser.setEmail(dto.getEmail());
        foundUser.setConsented(dto.isConsented());
        foundUser.setAboutMe(dto.getAboutMe());

        // save
        User updatedUser = userRepository.save(foundUser);

        // convert result to dto
        return userMapper.toDto(updatedUser);
    }

    public void delete(Long id) {
        log.info("deleting user: {}", id);

        userRepository.deleteById(id);
    }
}
