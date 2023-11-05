package ma.yc.marjane.mapper.impl;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.entity.AdminGeneral;
import ma.yc.marjane.mapper.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;


class AdminGeneralMapperImplTest {

    private Mapper<AdminGeneral , UserDto> adminGeneralMapper;
    @BeforeEach
    void setUp() {
        this.adminGeneralMapper = new AdminGeneralMapperImpl();

    }

    @Test
    void toEntity() {
        UserDto userDto = new UserDto();
        userDto.setPassword("password");
        userDto.setEmail("email");
        userDto.setUsername("username");
        AdminGeneral adminGeneral = this.adminGeneralMapper.toEntity(userDto);

        assertEquals(adminGeneral.getEmail(),userDto.getEmail());
        assertEquals(adminGeneral.getPassword(),userDto.getPassword());
        assertEquals(adminGeneral.getUsername(),userDto.getUsername());


    }

    @Test
    void toDto() {
        AdminGeneral adminGeneral = new AdminGeneral();
        adminGeneral.setEmail("email");
        adminGeneral.setPassword("password");
        adminGeneral.setUsername("username");
        UserDto userDto = this.adminGeneralMapper.toDto(adminGeneral);

        assertEquals(adminGeneral.getEmail(),userDto.getEmail());
        assertEquals(adminGeneral.getPassword(),userDto.getPassword());
        assertEquals(adminGeneral.getUsername(),userDto.getUsername());

    }

}