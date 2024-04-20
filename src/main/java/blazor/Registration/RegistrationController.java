package blazor.Registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZYP on 2024/4/19 12:59AM
 */
@RestController
@RequestMapping(path = "/user/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
