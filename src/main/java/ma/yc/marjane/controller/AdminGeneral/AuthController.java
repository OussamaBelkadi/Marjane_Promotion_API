package ma.yc.marjane.controller.AdminGeneral;

import jakarta.annotation.Resource;
import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.dto.projectDto.AdminGeneralDto;
import ma.yc.marjane.exception.ResourceNotFoundException;
import ma.yc.marjane.services.AuthentificationService;
import ma.yc.marjane.services.AuthentificationServiceAdmCtr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin-general")
public class AuthController {


    @Autowired
    @Qualifier("AdminGeneralAuthentificationServiceImpl")
    private AuthentificationService<AdminGeneralDto> authentificationService;
    @Autowired
    @Qualifier("AdminCentreAuthentificationServiceImpl")
    private AuthentificationServiceAdmCtr<AdminCentreDto> authentificationServiceAdminCentre;

    @PostMapping("/login")
    public AdminGeneralDto login(@RequestBody AdminGeneralDto adminGeneralDto){
        return this.authentificationService.login(adminGeneralDto);
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

    @PostMapping("/register")
    public AdminCentreDto register(@RequestBody AdminCentreDto adminCentreDto){
        return authentificationServiceAdminCentre.register(adminCentreDto);
    }

    @DeleteMapping("/deleteAdminCentre/{id}")
    public ResponseEntity<?> deleteAdminCentre(@PathVariable  AdminCentreDto adminCentreDto){
        try {
            authentificationServiceAdminCentre.deleteAdminCentre(adminCentreDto);
            return ResponseEntity.ok("Admin est suprimer avec success");
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
