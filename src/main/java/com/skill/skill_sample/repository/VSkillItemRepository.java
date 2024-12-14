package com.skill.skill_sample.repository;

import com.skill.skill_sample.entity.SkillItem;
import com.skill.skill_sample.entity.VSkillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VSkillItemRepository extends JpaRepository<VSkillItem, Integer> {

}
