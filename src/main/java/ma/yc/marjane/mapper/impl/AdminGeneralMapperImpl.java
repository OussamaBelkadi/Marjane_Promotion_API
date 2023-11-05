package ma.yc.marjane.mapper.impl;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.entity.AdminGeneral;
import ma.yc.marjane.mapper.Mapper;

public class AdminGeneralMapperImpl implements Mapper<AdminGeneral, UserDto> {
    @Override
    public AdminGeneral toEntity(UserDto dto) {
        if (dto != null) {
            return AdminGeneral.builder()
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .username(dto.getUsername())
                    .build();
        }
        return null;
    }

    @Override
    public UserDto toDto(AdminGeneral entity) {
        if(entity != null){
            return UserDto.builder()
                    .email(entity.getEmail())
                    .password(entity.getPassword())
                    .username(entity.getUsername())
                    .build();
        }
        return null;
    }


}
