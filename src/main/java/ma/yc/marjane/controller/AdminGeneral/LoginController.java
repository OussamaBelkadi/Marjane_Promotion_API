package ma.yc.marjane.controller.AdminGeneral;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.services.AuthentificationService;
import ma.yc.marjane.services.impl.AdminGeneralAuthentificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/adminGeneral")
public class LoginController {


    @Autowired
    @Qualifier("AdminGeneralAuthentificationService")
    private AuthentificationService authentificationService;

    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto userDto){
        return this.authentificationService.login(userDto);
//        return this.authentificationService.login(userDto);
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody  UserDto userDto){
        return authentificationService.register(userDto);
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
