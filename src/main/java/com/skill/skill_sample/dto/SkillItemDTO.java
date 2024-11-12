package com.skill.skill_sample.dto;

import java.util.Date;

public class SkillItemDTO {
    private int itemPk;
    private String user;
    private String lrgCtgr;
    private String smlCtgr;
    private String skillTitle;
    private String skillContent;
    private Date createdDttm;
    private Date updatedDttm;

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

    public Date getCreatedDttm() {
        return createdDttm;
    }

    public void setCreatedDttm(Date createdDttm) {
        this.createdDttm = createdDttm;
    }

    public Date getUpdatedDttm() {
        return updatedDttm;
    }

    public void setUpdatedDttm(Date updatedDttm) {
        this.updatedDttm = updatedDttm;
    }
}