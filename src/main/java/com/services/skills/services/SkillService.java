package com.services.skills.services;

import com.services.skills.entity.SkillEntity;
import com.services.skills.repositories.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepo skillRepo;

    public ResponseEntity<List<SkillEntity>> getAllSkills() {
        return ResponseEntity.ok().body(skillRepo.findAll());
    }

    public ResponseEntity<String> addSkill(SkillEntity skillEntity) {
        if (skillRepo.existsBySkill(skillEntity.getSkill()))
            return ResponseEntity.badRequest().body("Skill already exists");
        skillRepo.save(skillEntity);
        return ResponseEntity.ok().body("Skill added successfully");
    }

    public ResponseEntity<String> deleteSkill(int id) {
        skillRepo.deleteById(id);
        return ResponseEntity.ok().body("Skill deleted successfully");
    }

    public ResponseEntity<String> updateSkill(SkillEntity skillEntity) {
        if (skillRepo.existsBySkill(skillEntity.getSkill()))
            return ResponseEntity.badRequest().body("Skill already exists");
        skillRepo.save(skillEntity);
        return ResponseEntity.ok().body("Skill updated successfully");
    }


}
