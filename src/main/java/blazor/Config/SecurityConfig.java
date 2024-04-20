package blazor.Config;

/**
 * Created by ZYP on 2024/4/19 10:47AM
 */
import blazor.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 开启Web Security服务
public class SecurityConfig {

    private AppUserService appUserService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Constructor injection for AppUserService and BCryptPasswordEncoder
    @Autowired
    public SecurityConfig(AppUserService appUserService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserService = appUserService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // Set the UserDetailsService
        provider.setUserDetailsService(appUserService);
        // Set the PasswordEncoder
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        // Return the configured provider wrapped in a ProviderManager
        return new ProviderManager(provider);
    }
}
