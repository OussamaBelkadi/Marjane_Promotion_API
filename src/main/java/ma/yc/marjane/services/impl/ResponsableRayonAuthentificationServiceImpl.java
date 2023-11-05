package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.entity.Responsable;
import ma.yc.marjane.mapper.Mapper;
import ma.yc.marjane.mapper.impl.ResponsableMapperImpl;
import ma.yc.marjane.repository.ResponsableAuthRepository;
import ma.yc.marjane.services.AuthentificationService;
import ma.yc.marjane.util.Utils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ResponsableRayonAuthentificationService")
@Transactional
public class ResponsableRayonAuthentificationServiceImpl implements AuthentificationService {


    private ResponsableAuthRepository responsableAuthRepository;
    private final Mapper<Responsable,UserDto> responsableMapper =  new ResponsableMapperImpl();
//    @Autowired
    public ResponsableRayonAuthentificationServiceImpl(ResponsableAuthRepository responsableAuthRepository) {
        this.responsableAuthRepository = responsableAuthRepository;
    }
    @Override
    public UserDto login(UserDto userDto) {
        Responsable Responsable = this.responsableAuthRepository.findByEmail(userDto.getEmail());
        if (Responsable !=null){
            // TODO: 3/11/2023 check password after you hash it
            if (Utils.checkPassword(userDto.getPassword(),Responsable.getPassword())){
                // TODO: 3/11/2023 mapper the user1 to userDto
                return this.responsableMapper.toDto(Responsable);
            }
            return  null;

        }
        return  null;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public UserDto register(UserDto userDto) {
        return null;
    }
}
