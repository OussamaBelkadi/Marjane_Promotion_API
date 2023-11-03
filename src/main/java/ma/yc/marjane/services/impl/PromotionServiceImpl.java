package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.PromotionDto;
import ma.yc.marjane.repository.PromotionRepository;
import ma.yc.marjane.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {

    private PromotionRepository promotionRepository;


    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<PromotionDto> getAll() {
        List<PromotionDto> promotionDtos = new ArrayList<>();
        this.promotionRepository.findAll().forEach(promotion -> {
            promotionDtos.add(PromotionDto.builder()
                    .id(promotion.getId())
                    .dateDebut(promotion.getDateDebut())
                    .status(promotion.getStatus())
                    .dateFin(promotion.getDateFin())
                    .description(promotion.getDescription())
                    .build());
        });

        return promotionDtos;
    }


}
