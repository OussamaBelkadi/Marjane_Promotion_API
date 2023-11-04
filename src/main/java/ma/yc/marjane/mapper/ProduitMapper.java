package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.projectDto.ProduitDto;
import ma.yc.marjane.entity.Produit;
import org.mapstruct.factory.Mappers;

public interface ProduitMapper {
    ProduitMapper produitMapper = Mappers.getMapper(ProduitMapper.class);

    Produit toEntity(ProduitDto produitDto);
    ProduitDto toDto(Produit produit);
}
