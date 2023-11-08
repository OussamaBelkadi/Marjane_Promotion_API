package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.ProduitDto;
import ma.yc.marjane.entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProduitMapper {
    ProduitMapper produitMapper = Mappers.getMapper(ProduitMapper.class);

    @Mapping(target = "id",source ="produitDto.id_pdt" )
    Produit toEntity(ProduitDto produitDto);

    @Mapping(target = "id_pdt",source = "produit.id")
    ProduitDto toDto(Produit produit);
}
