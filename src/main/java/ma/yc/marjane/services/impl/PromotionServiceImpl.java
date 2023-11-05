package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.projectDto.PromotionDto;
import ma.yc.marjane.mapper.PromotiomMapper;
import ma.yc.marjane.repository.PromotionRepository;
import ma.yc.marjane.services.PromotionService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {

    private PromotionRepository promotionRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(PromotionServiceImpl.class);


    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<PromotionDto> getAll() {

        logger.info("getAll");
        List<PromotionDto> promotionDtos = new ArrayList<>();
        this.promotionRepository.findAll().forEach(promotion -> {
            promotionDtos.add(PromotiomMapper.promotionMapper.toDto(promotion));
        });

        return promotionDtos;
    }


}
