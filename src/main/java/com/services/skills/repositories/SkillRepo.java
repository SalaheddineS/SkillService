package com.services.skills.repositories;

import com.services.skills.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SkillRepo extends JpaRepository<SkillEntity, Integer> {
boolean existsBySkill(String skill);
}
