package com.skill.skill_sample.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_item")
public class SkillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemPk;
    private String user;
    private String lrgCtgr;
    private String smlCtgr;
    private String skillTitle;

    @Lob
    private String skillContent;
    private java.util.Date createdDttm;
    private java.util.Date updatedDttm;

    // Getters and Setters
    public int getItemPk() {
        return itemPk;
    }

    public void setItemPk(int itemPk) {
        this.itemPk = itemPk;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLrgCtgr() {
        return lrgCtgr;
    }

    public void setLrgCtgr(String lrgCtgr) {
        this.lrgCtgr = lrgCtgr;
    }

    public String getSmlCtgr() {
        return smlCtgr;
    }

    public void setSmlCtgr(String smlCtgr) {
        this.smlCtgr = smlCtgr;
    }

    public String getSkillTitle() {
        return skillTitle;
    }

    public void setSkillTitle(String skillTitle) {
        this.skillTitle = skillTitle;
    }

    public String getSkillContent() {
        return skillContent;
    }

    public void setSkillContent(String skillContent) {
        this.skillContent = skillContent;
    }

    public java.util.Date getCreatedDttm() {
        return createdDttm;
    }

    public void setCreatedDttm(java.util.Date createdDttm) {
        this.createdDttm = createdDttm;
    }

    public java.util.Date getUpdatedDttm() {
        return updatedDttm;
    }

    public void setUpdatedDttm(java.util.Date updatedDttm) {
        this.updatedDttm = updatedDttm;
    }
}