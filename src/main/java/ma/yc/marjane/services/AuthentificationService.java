package ma.yc.marjane.services;

import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.exception.CustomException;

public interface AuthentificationService <DTO, Entity>{
//    DTO login(DTO dto) throws CustomException;
    boolean logout();
    Entity register(DTO dto);
    boolean login(DTO dto);

}
