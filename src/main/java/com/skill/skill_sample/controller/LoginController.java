package com.skill.skill_sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}