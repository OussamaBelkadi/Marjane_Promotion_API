package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.ProduitDto;
import ma.yc.marjane.entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProduitMapper {
    ProduitMapper produitMapper = Mappers.getMapper(ProduitMapper.class);

    Produit toEntity(ProduitDto produitDto);
    ProduitDto toDto(Produit produit);
}
