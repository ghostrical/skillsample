package com.skill.skill_sample.repository;

import com.skill.skill_sample.entity.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserList, String> {
}