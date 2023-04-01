package com.services.skills.controllers;

import com.services.skills.entity.SkillEntity;
import com.services.skills.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("/api/v1/skill")
public class SkillController {

    @Autowired
    SkillService _skillService;

    @GetMapping("/getSkills")
    public ResponseEntity get() {
        return _skillService.getAllSkills();
    }

    @PostMapping("/addSkills")
    public ResponseEntity add(@RequestBody SkillEntity skill){
        return _skillService.addSkill(skill);
    }


    @DeleteMapping("/deleteSkills/{id}")
    public ResponseEntity delete(@PathVariable int id){
        return _skillService.deleteSkill(id);
    }

    @PutMapping("/updateSkills")
    public ResponseEntity update(@RequestBody SkillEntity skill){
        return _skillService.updateSkill(skill);
    }
}

