package ma.yc.marjane.services;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.exception.CustomException;

public interface AuthentificationService <D> {
//    D login(D D) throws CustomException;
    boolean logout();
    D register(D d);
    D login(D d);

}
