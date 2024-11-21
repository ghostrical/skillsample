package com.skill.skill_sample.security;

import com.skill.skill_sample.entity.UserList;
import com.skill.skill_sample.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("여긴 오긴하냐?4");

        UserList userList = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        System.out.println("여긴 오긴하냐?5");


        return User.builder()
                .username(userList.getUserId())
                .password(userList.getUserPassword())  // base64로 변환된 패스워드 사용
                .roles(userList.getUserAuth())
                .build();
    }
}