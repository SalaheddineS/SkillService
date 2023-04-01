package com.services.skills.entity;

import com.services.skills.Enums.FieldEnums;
import jakarta.persistence.*;

@Entity
public class SkillEntity {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private FieldEnums field;

    private String skill;

    public SkillEntity(int id, FieldEnums field, String skill) {
        this.id = id;
        this.field = field;
        this.skill = skill;
    }

    public SkillEntity(FieldEnums field, String skill) {
        this.field = field;
        this.skill = skill;
    }

    public SkillEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FieldEnums getField() {
        return field;
    }

    public void setField(FieldEnums field) {
        this.field = field;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}

