package ma.yc.marjane.controller.AdminGeneral;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.dto.projectDto.AdminGeneralDto;
import ma.yc.marjane.entity.AdminGeneral;
import ma.yc.marjane.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin-general")
public class AuthController {


    @Autowired
    @Qualifier("AdminGeneralAuthentificationServiceImpl")
    private AuthentificationService<AdminGeneralDto> authentificationService;

    @PostMapping("/login")
    public AdminGeneralDto login(@RequestBody AdminGeneralDto adminGeneralDto){
        return this.authentificationService.login(adminGeneralDto);
//        return this.authentificationService.login(userDto);
    }

    @PostMapping("/register")
    public AdminGeneralDto register(@RequestBody AdminGeneralDto adminGeneralDto){
        AdminGeneralDto adminGeneralDto1 = adminGeneralDto;
        return authentificationService.register(adminGeneralDto);
    }

    @GetMapping("/logout")
    public boolean logout(){
        return authentificationService.logout();
    }

    @GetMapping("/resetPassword")
    public boolean resetPassword(){
        return false;
    }

    @GetMapping("/refershToken")
    public boolean refershToken(){
        return false;
    }



}
