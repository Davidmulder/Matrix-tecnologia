package spring.contrato.contratos.Usuario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// para configuração do secury para se usaro aqui
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desativa CSRF
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().permitAll()  // Permite todas as requisições sem autenticação
                );

        return http.build();
    }
}
