package com.skill.skill_sample.config;

import com.skill.skill_sample.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    // CSRF 활성시도함.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(form -> form
                        .loginPage("/login")  // 로그인 페이지 URL
                    //    .loginProcessingUrl("/login") // 이걸 넣어도 안되는건가? 있든 없든 상관없네
                        .defaultSuccessUrl("/skill", true)  // 로그인 성공 후 리다이렉트 URL ... 일단 이건 html이 아니라 GETMapping 요청대로 쓰는게 맞았고.. skill_main 이 아니야..
                        .failureUrl("/login?error=true")  // 로그인 실패 후 리다이렉트 URL
                )
                .authenticationManager(authenticationManager(http))  // AuthenticationManager 설정
                .logout(logout -> logout
                        .logoutUrl("/logout")  // 로그아웃 URL
                        .logoutSuccessUrl("/login")  // 로그아웃 후 리다이렉트 URL
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()  // 로그인 페이지와 리소스는 모두 허용
                        .requestMatchers("/skill").authenticated()  // /skill은 로그인 후 접근 가능.. 이것도 /skill_main 이 아니라 GETMapping 요청대로다.
                        .anyRequest().denyAll()  // 나머지 요청은 모두 거부
                )
                .csrf(csrf -> csrf
                        .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/logout","POST"))
                        );

        return http.build();
    }



    // 내가 시도했던 new Customizer 방식으로 시도... 성공했다. 결국 원인은 url /skill을 /skill_main 으로 적은 것과, csrf 때문이었네.
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>() {
//                    @Override
//                    public void customize(FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer) {
//                        httpSecurityFormLoginConfigurer
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/skill", true)
//                                .failureUrl("/login?error=true");
//                    }
//                })
//                .authenticationManager(authenticationManager(http))
//                .logout(new Customizer<LogoutConfigurer<HttpSecurity>>() {
//                    @Override
//                    public void customize(LogoutConfigurer<HttpSecurity> httpSecurityLogoutConfigurer) {
//                        httpSecurityLogoutConfigurer
//                                .logoutUrl("/logout")
//                                .logoutSuccessUrl("/login");
//                    }
//                })
//                .authorizeHttpRequests(new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//                    @Override
//                    public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
//                        authorizationManagerRequestMatcherRegistry
//                                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
//                                .requestMatchers("/skill").authenticated()
//                                .anyRequest().denyAll();
//                    }
//                })
//                .csrf(new Customizer<CsrfConfigurer<HttpSecurity>>() {
//                    @Override
//                    public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//                        httpSecurityCsrfConfigurer.disable();
//                    }
//                });
//
//        return http.build();
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // 비밀번호 인코딩
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)  // UserDetailsService 설정
                .passwordEncoder(passwordEncoder());  // 비밀번호 인코딩 설정

        return authenticationManagerBuilder.build();
    }
}