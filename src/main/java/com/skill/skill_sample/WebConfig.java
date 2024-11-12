package com.skill.skill_sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
// 멍청한 skill_mod.html 에서 method 를 patch 로 하면 get로 전송되고 url 뒤 ?가 붙어서 skillItem객체들이 다닥다닥 붙어버린다.
// 그래서 method를 post로 하되 <input type="hidden" name="_method" value="PATCH"/> 를 붙여서 보냈고
// 실질적으로 controller에서 patch 로 타겠금 해주는게 이 클래스와 아래의     hiddenHttpMethodFilter() 임.


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
