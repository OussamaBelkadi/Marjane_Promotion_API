package ma.yc.marjane.controller.ResponsableRayonController;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/responsable-rayon")
public class AuthController {


    @Autowired
    @Qualifier("ResponsableRayonAuthentificationService")
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
