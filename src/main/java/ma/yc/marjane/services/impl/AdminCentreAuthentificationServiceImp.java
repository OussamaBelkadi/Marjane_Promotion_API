package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.mapper.AdminCentreMapper;
import ma.yc.marjane.repository.AdminCentreAuthetificationRepository;
import ma.yc.marjane.services.AuthentificationService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("AdminCentreAuthentificationServiceImp")
@Transactional
public class AdminCentreAuthentificationServiceImp implements AuthentificationService<AdminCentreDto, AdminCentre>{

//    private final AdminCentreDto adminCentreDto = new AdminCentreDto();

    private AdminCentreAuthetificationRepository adminCentreAuthetificationRepository;
    @Autowired
    public AdminCentreAuthentificationServiceImp( AdminCentreAuthetificationRepository adminCentreAuthetificationRepository){
        this.adminCentreAuthetificationRepository = adminCentreAuthetificationRepository;
    }

    @Override
    public boolean logout() {
        return false;
    }


    @Override
    public boolean login(AdminCentreDto adminCentreDto) {
        boolean result = false;
        AdminCentre adminCentre = AdminCentreMapper.adminCentreMapper.toEntity(adminCentreDto);
        AdminCentre adminCentreRslt =adminCentreAuthetificationRepository.findByEmail(adminCentre.getEmail());
        if(adminCentreRslt != null){
            if (BCrypt.checkpw(adminCentre.getPassword(), adminCentreRslt.getPassword())){
                result = true;
            }
        }
        return result;
    }

    @Override
    public AdminCentre register(AdminCentreDto adminCentreDto) {
        AdminCentre adminCentre = AdminCentreMapper.adminCentreMapper.toEntity(adminCentreDto);
        adminCentre.setPassword(BCrypt.hashpw(adminCentre.getPassword(), BCrypt.gensalt()));
        adminCentre = adminCentreAuthetificationRepository.save(adminCentre);
        return adminCentre;
    }

}
