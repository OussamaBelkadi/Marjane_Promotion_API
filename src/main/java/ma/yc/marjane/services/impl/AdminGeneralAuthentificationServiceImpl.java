package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.AdminGeneralDto;
import ma.yc.marjane.entity.AdminGeneral;
import ma.yc.marjane.exception.ResourceNotFoundException;
import ma.yc.marjane.mapper.AdminGeneralMapper;
import ma.yc.marjane.repository.AdminGeneralAuthentificationRespository;
import ma.yc.marjane.services.AuthentificationService;
import ma.yc.marjane.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Qualifier("AdminGeneralAuthentificationServiceImpl")
public class AdminGeneralAuthentificationServiceImpl implements AuthentificationService<AdminGeneralDto> {



    @Autowired
    private AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository;




    @Override
    public AdminGeneralDto login(AdminGeneralDto userDto) {
        AdminGeneral user1 = this.adminGeneralAuthentificationRespository.findByEmail(userDto.getEmail());
        if(user1 != null){
            if(Utils.hashPassword(userDto.getPassword()).equals(user1.getPassword())){
                AdminGeneralDto adminGeneralDto = new AdminGeneralDto();
                adminGeneralDto.setEmail(user1.getEmail());
                adminGeneralDto.setPassword(user1.getPassword());
                adminGeneralDto.setNom(user1.getNom());
                return adminGeneralDto;
            }else{
                throw new ResourceNotFoundException(" mot de passe incorrect");
            }
        }
        throw new ResourceNotFoundException("Email  incorrect");
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public AdminGeneralDto register(AdminGeneralDto adminGeneralDto) {
        AdminGeneral adminGeneral = AdminGeneralMapper.adminGeneralMapper.toEntity(adminGeneralDto);
        adminGeneral.setPassword(Utils.hashPassword(adminGeneral.getPassword()));
        adminGeneral = this.adminGeneralAuthentificationRespository.save(adminGeneral);
        return AdminGeneralMapper.adminGeneralMapper.toDto(adminGeneral);
    }
}
