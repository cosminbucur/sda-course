package com.sda.spring.data.jpa.validation;

import com.sda.spring.data.jpa.validation.dto.UserReadDto;
import com.sda.spring.data.jpa.validation.dto.UserWriteDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Configuration
public class ValidationConfig {

    private static final Logger log = LoggerFactory.getLogger(ValidationConfig.class);

    @Autowired
    private UserService userService;

    @Bean
    public CommandLineRunner validationData() {
        return args -> {
            testProgrammaticValidations();
            testService();
        };
    }

    private void testProgrammaticValidations() {
        UserWriteDto userDto = createUser();
        isValid(userDto);

        UserWriteDto badUserDto = createBadUser();
        isValid(badUserDto);
    }

    // programmatic validation
    private boolean isValid(UserWriteDto dto) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<UserWriteDto>> constraintViolations = validator.validate(dto);

        if (!constraintViolations.isEmpty()) {
            log.error("validating user: {}", dto);
            constraintViolations
                    .forEach(violation -> log.error("violation: {}", violation.getMessage()));
            return false;
        }
        return true;
    }

    private void testService() {
        UserWriteDto userDto = createUser();

        UserReadDto savedDto = userService.save(userDto);

        List<UserReadDto> allUserReadDto = userService.findAll();

        UserReadDto foundUserDto = userService.findById(savedDto.getId())
                .orElseThrow(() -> new RuntimeException("user not found"));

        UserWriteDto updateDto = new UserWriteDto();
        updateDto.setName("anna");
        updateDto.setEmail("anna@gmail.com");
        updateDto.setConsented(true);
        updateDto.setAge(30);
        updateDto.setAboutMe("retired and happy");
        UserReadDto updatedDto = userService.update(savedDto.getId(), updateDto);

        userService.delete(savedDto.getId());
    }

    private UserWriteDto createUser() {
        UserWriteDto dto = new UserWriteDto();
        dto.setName("jon snow");
        dto.setEmail("jonsnow@gmail.com");
        dto.setAge(30);
        dto.setConsented(true);
        dto.setAboutMe("I'm a watcher on the wall");
        return dto;
    }

    private UserWriteDto createBadUser() {
        UserWriteDto dto = new UserWriteDto();
        dto.setName("");
        dto.setEmail("jonsnowgmail.com");
        dto.setAge(5);
        dto.setConsented(false);
        dto.setAboutMe("...");
        return dto;
    }

}
