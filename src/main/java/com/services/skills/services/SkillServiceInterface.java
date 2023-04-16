package com.services.skills.services;

import com.services.skills.entity.SkillEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillServiceInterface {
    public boolean existsBySkill(String skill);
    public ResponseEntity<List<SkillEntity>> getAllSkills();
    public ResponseEntity<String> addSkill(SkillEntity skillEntity);
    public ResponseEntity<String> deleteSkill(int id);
    public ResponseEntity<String> updateSkill(SkillEntity skillEntity);

}
