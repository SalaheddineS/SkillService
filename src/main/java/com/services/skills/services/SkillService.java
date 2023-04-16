package com.services.skills.services;

import com.services.skills.ApiCalls.AdminVerification;
import com.services.skills.entity.SkillEntity;
import com.services.skills.repositories.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class SkillService implements SkillServiceInterface {

    @Autowired
    SkillRepo skillRepo;
    @Autowired
    AdminVerification adminVerification;
    @Override
    public boolean existsBySkill(String skill) {
        return skillRepo.existsBySkill(skill);
    }
    @Override
    public ResponseEntity<List<SkillEntity>> getAllSkills() {
        return ResponseEntity.ok().body(skillRepo.findAll());
    }
    @Override
    public ResponseEntity<String> addSkill(SkillEntity skillEntity) {

        if (skillRepo.existsBySkill(skillEntity.getSkill()))
            return ResponseEntity.badRequest().body("Skill already exists");
        skillRepo.save(skillEntity);
        return ResponseEntity.ok().body("Skill added successfully");
    }
    @Override
    public ResponseEntity<String> deleteSkill(int id) {

        skillRepo.deleteById(id);
        return ResponseEntity.ok().body("Skill deleted successfully");
    }

    @Override
    public ResponseEntity<String> updateSkill(SkillEntity skillEntity) {

        if (skillRepo.existsBySkill(skillEntity.getSkill()))
            return ResponseEntity.badRequest().body("Skill already exists");
        skillRepo.save(skillEntity);
        return ResponseEntity.ok().body("Skill updated successfully");
    }


}
