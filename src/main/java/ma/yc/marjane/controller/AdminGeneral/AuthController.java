package ma.yc.marjane.controller.AdminGeneral;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin-general")
public class AuthController {


    @Autowired
    @Qualifier("AdminGeneralAuthentificationService")
    private AuthentificationService authentificationService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto){
        return ResponseEntity.ok(this.authentificationService.login(userDto));
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
