package ma.yc.marjane.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.marjane.dto.ResponsableDto;
import ma.yc.marjane.entity.Responsable;
import ma.yc.marjane.mapper.Mapper;
import ma.yc.marjane.mapper.ResponsableMapper;
import ma.yc.marjane.repository.ResponsableAuthRepository;
import ma.yc.marjane.services.AuthentificationService;
import ma.yc.marjane.util.Utils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ResponsableRayonAuthentificationService")
@Transactional
public class ResponsableRayonAuthentificationServiceImpl implements AuthentificationService<ResponsableDto> {


    private ResponsableAuthRepository responsableAuthRepository;
    private final ResponsableMapper responsableMapper = ResponsableMapper.Instance;
//    @Autowired
    public ResponsableRayonAuthentificationServiceImpl(ResponsableAuthRepository responsableAuthRepository) {
        this.responsableAuthRepository = responsableAuthRepository;

    }
    @Override
    public ResponsableDto login(ResponsableDto responsableDto) {
        Responsable responsable = this.responsableAuthRepository.findByEmail(responsableDto.getEmail());
        if (responsable !=null){

            // TODO: 3/11/2023 check password after you hash it
            if (Utils.checkPassword(responsableDto.getPassword(),responsable.getPassword())){
                // TODO: 3/11/2023 mapper the user1 to userDto
//                return true;
                return this.responsableMapper.toDto(responsable);
            }
            throw new RuntimeException("password is not correct");
        }
        throw new RuntimeException("user not found");
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public ResponsableDto register(ResponsableDto responsableDto) {
        Responsable responsable = this.responsableAuthRepository.findByEmail(responsableDto.getEmail());
        if (responsable == null){
            Responsable responsable1 = this.responsableMapper.toEntity(responsableDto);
            // TODO: 11/11/2023 very password before  hashing it and  save it
            responsable1.setPassword(Utils.hashPassword(responsable1.getPassword()));
            this.responsableAuthRepository.save(responsable1);

        }else{
            throw new RuntimeException("user already exist");
        }
        return responsableDto;
    }


}
