package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.entity.User;
import ma.yc.marjane.repository.AdminGeneralAuthentificationRespository;
import ma.yc.marjane.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminGeneralAuthentificationServiceImpl implements AuthentificationService {



//    @Autowired
//    private AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository;



    @Override
    public UserDto login(UserDto userDto) {
//        User user1 = this.adminGeneralAuthentificationRespository.findByEmail(userDto.getEmail());
//        if(user1 != null){
//            if(user1.getPassword().equals(userDto.getPassword())){
//                return UserDto.builder()
//                        .email(user1.getEmail())
//                        .password(user1.getPassword())
//                        .build();
//            }
//        }
        return null;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
