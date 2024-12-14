package com.skill.skill_sample.mapper;

import com.skill.skill_sample.entity.CommonTable;
import com.skill.skill_sample.entity.SkillItem;

import java.util.List;

public class CommonMapper {
    public SkillItem CommIdToCommName (SkillItem skillItem, List<CommonTable> commonTableList){

        if(skillItem.equals(null) || commonTableList.size() == 0) return null;

        String lrgCtgr = skillItem.getLrgCtgr();
        String smlCtgr = skillItem.getSmlCtgr();

        for(CommonTable c : commonTableList){
            if(c.getCommId().equals(lrgCtgr)){
                skillItem.setLrgCtgr(c.getCommName());
                break;
            }
        }

        for(CommonTable c : commonTableList){
            if(c.getCommId().equals(smlCtgr)){
                skillItem.setSmlCtgr(c.getCommName());
                break;
            }
        }

        return skillItem;
    }
}
