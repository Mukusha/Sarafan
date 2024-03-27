package smile.sarafan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;
import smile.sarafan.service.UserService;

@Configuration
public class SecurityConfig {
    private final UserService userService;

    @Autowired
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //.cors(Customizer.withDefaults())//&
        http.csrf(AbstractHttpConfigurer::disable)
                //все страницы требуют авторизации кроме страницы входа
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/login**", "/js/**", "/error**").permitAll()
                        .anyRequest().authenticated())
                //что бы по логину паролю можно было зайти
                //    .formLogin(Customizer.withDefaults())
                //перенаправление если запрашивают страницу без авторизации
                .exceptionHandling((exceptions) -> exceptions
                        .defaultAuthenticationEntryPointFor(
                                new LoginUrlAuthenticationEntryPoint("/"),
                                new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
                        )
                )
                //аутентификация через google
                .oauth2Login(oauth2 -> oauth2
                        .successHandler((request, response, authentication) -> {
                            if (authentication != null) {
                                DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
                                userService.processOAuthPostLogin(oauthUser);
                                response.sendRedirect("/");
                            }
                        }))
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}