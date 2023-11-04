package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.exception.CustomException;
import ma.yc.marjane.mapper.AdminCentreMapper;
import ma.yc.marjane.repository.AdminCentreAuthetificationRepository;
import ma.yc.marjane.services.AuthentificationService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@Qualifier("adminCentre")
public class AdminCentreAuthentificationServiceImp implements AuthentificationService {

    private final AdminCentreDto adminCentreDto = new AdminCentreDto();

    private AdminCentreAuthetificationRepository adminCentreAuthetificationRepository;
    @Autowired
    public AdminCentreAuthentificationServiceImp( AdminCentreAuthetificationRepository adminCentreAuthetificationRepository){
        this.adminCentreAuthetificationRepository = adminCentreAuthetificationRepository;
    }
    @Override
    public Object login(Object o) throws CustomException {
        return null;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public AdminCentre register(AdminCentreDto adminCentreDto) {
        AdminCentre adminCentre = AdminCentreMapper.adminCentreMapper.toEntity(adminCentreDto);
        adminCentre.setPassword(BCrypt.hashpw(adminCentre.getPassword(), BCrypt.gensalt()));
        adminCentre = adminCentreAuthetificationRepository.save(adminCentre);
        return adminCentre;
    }

}
