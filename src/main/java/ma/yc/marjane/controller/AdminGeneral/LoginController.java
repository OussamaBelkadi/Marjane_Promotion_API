package ma.yc.marjane.controller.AdminGeneral;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.dto.projectDto.AdminGeneralDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.entity.AdminGeneral;
import ma.yc.marjane.services.impl.AdminCentreAuthentificationServiceImp;
import ma.yc.marjane.services.impl.AdminGeneralAuthentificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/adminGeneral/login")
public class LoginController {


    private final AdminGeneralAuthentificationServiceImpl adminGeneralAuthentificationService;
    private final AdminCentreAuthentificationServiceImp adminCentreAuthentificationServiceImp;

    @Autowired
    public LoginController(@Qualifier("AdminGeneralAuthentificationServiceImpl") AdminGeneralAuthentificationServiceImpl adminGeneralAuthentificationService,
                           @Qualifier("AdminCentreAuthentificationServiceImp") AdminCentreAuthentificationServiceImp adminCentreAuthentificationService){
        this.adminGeneralAuthentificationService = adminGeneralAuthentificationService;
        this.adminCentreAuthentificationServiceImp = adminCentreAuthentificationService;
    }

    @PostMapping("/regesterAdminCentre")
    public AdminCentre registerAdminCentre(@RequestBody AdminCentreDto adminCentreDto){
        return adminCentreAuthentificationServiceImp.register(adminCentreDto);

    }
    @PostMapping("/regester")
    public AdminGeneral register(@RequestBody AdminGeneralDto adminGeneralDto){
        return adminGeneralAuthentificationService.register(adminGeneralDto);
    }

    @PostMapping ("/login")
    public boolean login(@RequestBody AdminGeneralDto adminGeneralDto){
        return adminGeneralAuthentificationService.login(adminGeneralDto);
    }


    @GetMapping
    public UserDto get(){
        return UserDto.builder()
                .email("email@example.com")
                .password("password")
                .build();
    }


}
