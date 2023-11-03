package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.entity.AdminGeneral;
import ma.yc.marjane.entity.User;
import ma.yc.marjane.mapper.Mapper;
import ma.yc.marjane.mapper.impl.AdminGeneralMapperImpl;
import ma.yc.marjane.repository.AdminGeneralAuthentificationRespository;
import ma.yc.marjane.services.AuthentificationService;
import ma.yc.marjane.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Qualifier("AdminGeneralAuthentificationService")
public class AdminGeneralAuthentificationServiceImpl implements AuthentificationService {

    private AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository;
    private final Mapper<AdminGeneral ,UserDto> adminGeneralMapper = new AdminGeneralMapperImpl();

    @Autowired
    public AdminGeneralAuthentificationServiceImpl(AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository) {
        this.adminGeneralAuthentificationRespository = adminGeneralAuthentificationRespository;
    }

    @Override
    public UserDto login(UserDto userDto) {
        AdminGeneral adminGeneral = this.adminGeneralAuthentificationRespository.findByEmail(userDto.getEmail());
     if (adminGeneral !=null){
         // TODO: 3/11/2023 check password after you hash it
         if (Utils.checkPassword(userDto.getPassword(),adminGeneral.getPassword())){
             // TODO: 3/11/2023 mapper the user1 to userDto
             return this.adminGeneralMapper.toDto(adminGeneral);
         }
         return  null;

     }
     return  null;
    }


    @Override
    public  UserDto register(UserDto userDto){
        AdminGeneral adminGeneral = this.adminGeneralMapper.toEntity(userDto);
        adminGeneral.setPassword(Utils.hashPassword(adminGeneral.getPassword()));
        adminGeneral = this.adminGeneralAuthentificationRespository.save(adminGeneral);
        return this.adminGeneralMapper.toDto(adminGeneral);
    }

    @Override
    public boolean logout() {
        return false;
    }
}
