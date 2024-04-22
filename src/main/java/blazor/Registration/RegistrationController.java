package blazor.Registration;

import blazor.Entity.AppUser;
import blazor.Service.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZYP on 2024/4/19 12:59AM
 */
@CrossOrigin(origins = "http://localhost:5277")
@Tag(name = "Registration")
@RestController
@RequestMapping(path = "/user/auth")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Operation(summary = "Registration")
    @PostMapping(path = "/registration")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
//        return "it works";
    }

    @Operation(summary = "Email Confirmation")
    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AppUser appUser) {

        return registrationService.loginUser(appUser);
    }
}
