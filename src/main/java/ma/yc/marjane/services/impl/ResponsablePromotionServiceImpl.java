package ma.yc.marjane.services.impl;

import ma.yc.marjane.dto.*;
import ma.yc.marjane.dto.projectDto.ResponsableDto;
import ma.yc.marjane.entity.Promotion;
import ma.yc.marjane.entity.Responsable;
import ma.yc.marjane.mapper.ResponsablePromotoinMapper;
import ma.yc.marjane.repository.PromotionRepository;
import ma.yc.marjane.repository.ResponsableAuthRepository;
import ma.yc.marjane.services.ResponsablePromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ResponsablePromotionServiceImpl implements ResponsablePromotionService {

    private ResponsableAuthRepository responsableAuthRepository;
    private PromotionRepository promotionRepository ;
    private ResponsablePromotoinMapper responsablePromotoinMapper ;


    @Autowired
    public ResponsablePromotionServiceImpl(ResponsableAuthRepository responsableAuthRepository,PromotionRepository promotionRepository) {
        this.responsableAuthRepository = responsableAuthRepository;
        this.promotionRepository = promotionRepository;
    }
    @Override
    public ResponsablePromotionResponse ApprouverOuRefuserPromotion(ResponsablePromotionRequest responsablePromotionRequest) {
        // first find the responsible .
        ResponsablePromotionResponse response  = new ResponsablePromotionResponse();
        if (this.findResponsableById(responsablePromotionRequest.getResponsableId()) == null){
            throw new ErrorResponse("Responsible not found","");
        }

        // :  loop into promotion and update their status
        if (responsablePromotionRequest.getPromotion().isEmpty()){
            return response;
        }else{
            for(ResponsablePromotionDto promotionDto : responsablePromotionRequest.getPromotion()){
                Optional<Promotion> promotion = this.promotionRepository.findById(promotionDto.getId());
                if (promotion.isPresent()){
                    promotion.get().setStatus(promotionDto.getStatus());
                    this.promotionRepository.save(promotion.get());
                    response.getPromotionDtos().add(this.responsablePromotoinMapper.toDto(promotion.get()));

                }
            }
        }
        return response;
    }

    public Responsable findResponsableById(Long responsableId){
        if (responsableId <1 ){
            return null;
        }
        Optional<Responsable> responsable = this.responsableAuthRepository.findById(responsableId);
        return responsable.orElse(null);
    }
}
