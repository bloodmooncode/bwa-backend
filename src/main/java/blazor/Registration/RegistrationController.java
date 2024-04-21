package blazor.Registration;

import blazor.Entity.AppUser;
import blazor.Service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZYP on 2024/4/19 12:59AM
 */
@RestController
@RequestMapping(path = "/user/auth")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(path = "/registration")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
//        return "it works";
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AppUser appUser) {

        return registrationService.loginUser(appUser);
    }
}
