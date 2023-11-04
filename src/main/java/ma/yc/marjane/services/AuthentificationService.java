package ma.yc.marjane.services;

import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.exception.CustomException;

public interface AuthentificationService <DTO>{
    public DTO login(DTO dto) throws CustomException;
    public boolean logout();
    public AdminCentre register(AdminCentreDto adminCentreDto);

}
