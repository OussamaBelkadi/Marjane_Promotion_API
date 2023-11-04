package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.dto.projectDto.AdminGeneralDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.entity.AdminGeneral;
import ma.yc.marjane.mapper.AdminCentreMapper;
import ma.yc.marjane.mapper.AdminGeneralMapper;
import ma.yc.marjane.repository.AdminCentreAuthetificationRepository;
import ma.yc.marjane.repository.AdminGeneralAuthentificationRespository;
import ma.yc.marjane.services.AuthentificationService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminGeneralAuthentificationServiceImpl")
@Transactional
public class AdminGeneralAuthentificationServiceImpl implements AuthentificationService<AdminGeneralDto, AdminGeneral>{



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

   private final AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository;
    @Autowired
    public AdminGeneralAuthentificationServiceImpl(AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository){
        this.adminGeneralAuthentificationRespository = adminGeneralAuthentificationRespository;

    }



    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public AdminGeneral register(AdminGeneralDto adminGeneralDto) {
        AdminGeneral adminGeneral = AdminGeneralMapper.adminGeneralMapper.toEntity(adminGeneralDto);
        adminGeneral.setPassword(BCrypt.hashpw(adminGeneral.getPassword(), BCrypt.gensalt()));
        adminGeneral = adminGeneralAuthentificationRespository.save(adminGeneral);
        return adminGeneral;
    }

    @Override
    public boolean login(AdminGeneralDto adminGeneralDto) {
        boolean result = false;
        AdminGeneral adminGeneral = AdminGeneralMapper.adminGeneralMapper.toEntity(adminGeneralDto);
        AdminGeneral adminGeneralRslt = adminGeneralAuthentificationRespository.findByEmail(adminGeneral.getEmail());
        if(adminGeneralRslt != null){
            if (BCrypt.checkpw(adminGeneral.getPassword(), adminGeneralRslt.getPassword())){
                result = true;
            }
        }
        return result;
    }
}
