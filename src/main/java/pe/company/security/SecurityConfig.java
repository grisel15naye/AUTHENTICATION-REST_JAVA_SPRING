package pe.company.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.swing.*;

@Configuration  // Le dice a Spring: "Esta clase tiene configuraciones"
@EnableWebSecurity  // Activa Spring Security en toda la aplicación
public class SecurityConfig {
    @Bean  // Crea un objeto que Spring va a usar
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception{
        httpSecurity
                .authorizeHttpRequests(auth ->auth // Configuración de permisos
                .requestMatchers("/listar_public").permitAll()// Acceso público
                .requestMatchers("/listar_admin").hasRole("ADMIN") // Acceso público
                .requestMatchers("/listar_user").hasRole("USER")   // Solo USER
                .anyRequest().authenticated()  // Todo lo demás requiere login

                )
                .httpBasic(Customizer.withDefaults())  // Autenticación básica HTTP
                .csrf(csrf -> csrf.disable()); // Desactiva CSRF (APIs REST)
        return httpSecurity.build(); // Retorna configuración construida
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity)throws Exception{
        // Obtiene el constructor de autenticación
        AuthenticationManagerBuilder authenticationManagerBuilder=
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);

        // Configura usuarios en memoria (RAM)
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("antoine").password(passwordEncoder().encode("a123")).roles("ADMIN")
                .and() // Agrega otro usuario
                .withUser("werther").password(passwordEncoder().encode("w123")).roles("USER");

        return authenticationManagerBuilder.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }// Encriptación segura
}
