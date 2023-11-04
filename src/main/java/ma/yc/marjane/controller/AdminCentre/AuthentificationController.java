package ma.yc.marjane.controller.AdminCentre;

import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.entity.AdminCentre;
import ma.yc.marjane.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adminCentre")
public class AuthentificationController {
    private AuthentificationService authentificationService;

    @Autowired
    public AuthentificationController(@Qualifier("adminCentre") AuthentificationService authentificationService){
        this.authentificationService = authentificationService;
    }
    @PostMapping("/register")
    public AdminCentre register(@RequestBody AdminCentreDto adminCentreDto){
        return authentificationService.register(adminCentreDto);
    }
}
