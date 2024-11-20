package com.skill.skill_sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()  // 권한 요청 설정
                .requestMatchers("/login", "/css/**", "/js/**").permitAll()  // 로그인과 리소스는 모두 허용
                .requestMatchers("/skill_main").authenticated()  // 로그인 후 /skill_main에 접근 허용
                .anyRequest().denyAll()  // 그 외의 모든 요청은 거부
                .and()
                .formLogin(withDefaults())  // 로그인 설정 (새로운 방식)
                .logout(withDefaults());    // 로그아웃 설정 (새로운 방식)

        return http.build();  // http 빌드하여 리턴
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // 비밀번호 인코딩
    }
}