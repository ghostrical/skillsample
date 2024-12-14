package com.skill.skill_sample.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "v_skill_item")
public class VSkillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemPk;
    private String user;
    private String lrgCtgrCd;
    private String lrgCtgr;
    private String smlCtgrCd;
    private String smlCtgr;
    private String skillTitle;
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

    public String getLrgCtgrCd() {
        return lrgCtgrCd;
    }

    public void setLrgCtgrCd(String lrgCtgrCd) {
        this.lrgCtgrCd = lrgCtgrCd;
    }

    public String getSmlCtgrCd() {
        return smlCtgrCd;
    }

    public void setSmlCtgrCd(String smlCtgrCd) {
        this.smlCtgrCd = smlCtgrCd;
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