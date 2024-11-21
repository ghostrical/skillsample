package com.skill.skill_sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // 로그인 페이지를 제공하는 핸들러
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // login.html을 반환합니다.
    }

    // 로그인 실패 시, 로그인 페이지로 돌아가도록 설정
    @GetMapping("/login?error=true")
    public String loginError() {
        return "login";  // 로그인 실패 시 login.html을 반환
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 콘솔에 출력
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // 인증을 처리하고 로그인 성공 페이지로 리다이렉트
        return "redirect:/skill_main";  // 로그인 성공 후 이동할 URL
    }

}