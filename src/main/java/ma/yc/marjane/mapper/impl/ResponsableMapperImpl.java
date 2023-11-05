package ma.yc.marjane.mapper.impl;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.entity.Responsable;
import ma.yc.marjane.mapper.Mapper;

public class ResponsableMapperImpl implements Mapper<Responsable , UserDto> {
    @Override
    public Responsable toEntity(UserDto dto) {
        if (dto != null) {
            return Responsable.builder()
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .username(dto.getUsername())
                    .build();
        }
        return null;
    }

    @Override
    public UserDto toDto(Responsable entity) {
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
