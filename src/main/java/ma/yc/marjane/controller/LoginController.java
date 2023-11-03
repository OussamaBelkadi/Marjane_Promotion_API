package ma.yc.marjane.controller;

import ma.yc.marjane.dto.UserDto;
import ma.yc.marjane.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adminGeneral/login")
public class LoginController {


    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping
    public UserDto login(UserDto userDto){
        return userDto;
//        return this.authentificationService.login(userDto);
    }

    @GetMapping
    public UserDto get(){
        return UserDto.builder()
                .email("email@example.com")
                .password("password")
                .build();
    }


}
