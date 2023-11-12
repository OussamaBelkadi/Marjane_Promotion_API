package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.VilleDto;
import ma.yc.marjane.entity.Ville;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VilleMapper {
    VilleMapper villeMapper = Mappers.getMapper(VilleMapper.class);

    Ville toEntity(VilleDto villeDto);
    VilleDto toDto(Ville ville);
}
