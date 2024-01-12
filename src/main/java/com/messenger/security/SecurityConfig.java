package com.messenger.security;

import com.messenger.repository.UsersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    private final UsersRepository usersRepository;

    public SecurityConfig(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Bean
    public UserDetailsService userDetailService(){
        return username -> {
            var user = usersRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found"));
            return new SecUser(user);
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/login.html", "/register").permitAll()
                .requestMatchers("/index.html").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login.html").successForwardUrl("/")
                .and()
                .httpBasic();
        return http.build();
    }

}
