package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.exception.CustomException;
import ma.yc.marjane.services.AuthentificationService;
import org.mapstruct.Qualifier;
import org.springframework.stereotype.Service;

@Service("AdminGeneralAuthentificationServiceImpl")
@Transactional
public class AdminGeneralAuthentificationServiceImpl implements AuthentificationService {



//    @Autowired
//    private AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository;



//    @Override
//    public UserDto login(UserDto userDto) throws CustomException {
//        try {
//
//        }catch (NullPointerException exception){
//            throw new CustomException("dssd");
//        }
////        User user1 = this.adminGeneralAuthentificationRespository.findByEmail(userDto.getEmail());
////        if(user1 != null){
////            if(user1.getPassword().equals(userDto.getPassword())){
////                return UserDto.builder()
////                        .email(user1.getEmail())
////                        .password(user1.getPassword())
////                        .build();
////            }
////        }
//        return null;
//    }

    @Override
    public boolean login(Object o) {
        return false;
    }


    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public Object register(Object o) {
        return null;
    }
}
