package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.projectDto.CategorieDto;
import ma.yc.marjane.entity.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategorieMapper {

    CategorieMapper categorieMapper = Mappers.getMapper(CategorieMapper.class);

    Categorie toEntity(CategorieDto categorieDto);

    CategorieDto toDto(Categorie categorie);
}
