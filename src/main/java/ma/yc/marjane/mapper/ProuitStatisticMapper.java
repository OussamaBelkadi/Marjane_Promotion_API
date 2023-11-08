package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.ProduitDto;
import ma.yc.marjane.dto.PromotionStatistiques;
import ma.yc.marjane.dto.ProuitStatisticDto;
import ma.yc.marjane.entity.Produit;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ProuitStatisticMapper {

    PromotionStatistiqueMapper INSTANCE = Mappers.getMapper(PromotionStatistiqueMapper.class);
    ProuitStatisticDto toDto(Produit produit);
}
