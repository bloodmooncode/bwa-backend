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
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
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
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 这个配置是关闭csrf
                .csrf(AbstractHttpConfigurer::disable)
                // 处理请求
                .authorizeHttpRequests(authorize -> {
                    // 放开哪些接口
                    authorize
                            .requestMatchers("/user/auth/**", "/user/auth/registration/**")
                            .permitAll();
                    // 其他的都需要认证
                    // authorize.anyRequest().authenticated();
                    authorize.anyRequest().permitAll(); // 暂时不设置认证网关
                })
                // 错误处理
                .exceptionHandling(m -> {
                });

        return http.build();
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
