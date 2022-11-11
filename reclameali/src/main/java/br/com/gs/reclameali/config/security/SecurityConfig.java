package br.com.gs.reclameali.config.security;

import br.com.gs.reclameali.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean



    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/api/usuario/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/usuario/").permitAll()
                .antMatchers("/h2/**").permitAll()
                .anyRequest().denyAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();
        ;

        return http.build();

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
