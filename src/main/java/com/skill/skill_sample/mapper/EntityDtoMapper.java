package com.skill.skill_sample.mapper;

import com.skill.skill_sample.dto.CommonTableDTO;
import com.skill.skill_sample.dto.SkillItemDTO;
import com.skill.skill_sample.dto.UserListDTO;
import com.skill.skill_sample.dto.VSkillItemDTO;
import com.skill.skill_sample.entity.CommonTable;
import com.skill.skill_sample.entity.SkillItem;
import com.skill.skill_sample.entity.UserList;
import com.skill.skill_sample.entity.VSkillItem;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class EntityDtoMapper {
    public CommonTableDTO CommonTableToCommonTableDto (CommonTable commonTable){

        if(commonTable.equals(null)) return null;

        CommonTableDTO commonTableDTO = new CommonTableDTO();
        commonTableDTO.setCommId(commonTable.getCommId());
        commonTableDTO.setCommName(commonTable.getCommName());

        return commonTableDTO;
    }

    public List<CommonTableDTO> CommonTableListToCommonTableDtoList (List<CommonTable> commonTableList){

        if(commonTableList.size() == 0) return new ArrayList<CommonTableDTO>();

        List<CommonTableDTO> commonTableDTOList = new ArrayList<CommonTableDTO>();
        for(CommonTable c : commonTableList){
            CommonTableDTO commonTableDTO = new CommonTableDTO();
            commonTableDTO.setCommId(c.getCommId());
            commonTableDTO.setCommName(c.getCommName());

            commonTableDTOList.add(commonTableDTO);
        }

        return commonTableDTOList;
    }

    public CommonTable CommonTableDtoToCommonTable (CommonTableDTO commonTableDTO){

        if(commonTableDTO.equals(null)) return null;

        CommonTable commonTable = new CommonTable();
        commonTable.setCommId(commonTableDTO.getCommId());
        commonTable.setCommName(commonTableDTO.getCommName());

        return commonTable;
    }

    public UserListDTO UserListToUserListDto (UserList userList){

        if(userList.equals(null)) return null;

        UserListDTO userListDTO = new UserListDTO();
        userListDTO.setUserId(userList.getUserId());
        userListDTO.setUserPassword(userList.getUserPassword());
        userListDTO.setUserAuth(userList.getUserAuth());

        return userListDTO;
    }

    public UserList UserListDtoToUserList (UserListDTO userListDTO){

        if(userListDTO.equals(null)) return null;

        UserList userList = new UserList();
        userList.setUserId(userListDTO.getUserId());
        userList.setUserPassword(userListDTO.getUserPassword());
        userList.setUserAuth(userListDTO.getUserAuth());

        return userList;

    }

    public SkillItemDTO SkillItemToSkillItemDto (SkillItem skillItem){

        if(skillItem.equals(null)) return null;

        SkillItemDTO skillItemDTO = new SkillItemDTO();
        skillItemDTO.setItemPk(skillItem.getItemPk());
        skillItemDTO.setUser(skillItem.getUser());
        skillItemDTO.setSkillTitle(skillItem.getSkillTitle());
        skillItemDTO.setLrgCtgr(skillItem.getLrgCtgr());
        skillItemDTO.setSmlCtgr(skillItem.getSmlCtgr());
        skillItemDTO.setSkillContent(skillItem.getSkillContent());
        skillItemDTO.setCreatedDttm(skillItem.getCreatedDttm());
        skillItemDTO.setUpdatedDttm(skillItem.getUpdatedDttm());

        return skillItemDTO;
    }

    public List<SkillItemDTO> SkillItemListToSkillItemDtoList (List<SkillItem> skillItemList){

        if(skillItemList.size() == 0) return new ArrayList<SkillItemDTO>();

        List<SkillItemDTO> skillItemDTOList = new ArrayList<SkillItemDTO>();
        for(SkillItem s : skillItemList){
            SkillItemDTO skillItemDTO = new SkillItemDTO();
            skillItemDTO.setItemPk(s.getItemPk());
            skillItemDTO.setUser(s.getUser());
            skillItemDTO.setSkillTitle(s.getSkillTitle());
            skillItemDTO.setLrgCtgr(s.getLrgCtgr());
            skillItemDTO.setSmlCtgr(s.getSmlCtgr());
            skillItemDTO.setSkillContent(s.getSkillContent());
            skillItemDTO.setCreatedDttm(s.getCreatedDttm());
            skillItemDTO.setUpdatedDttm(s.getUpdatedDttm());

            skillItemDTOList.add(skillItemDTO);
        }

        return skillItemDTOList;

    }

    public SkillItem SkillItemDtoToSkillItem (SkillItemDTO skillItemDTO){
        SkillItem skillItem = new SkillItem();
        skillItem.setItemPk(skillItemDTO.getItemPk());
        skillItem.setUser(skillItemDTO.getUser());
        skillItem.setSkillTitle(skillItemDTO.getSkillTitle());
        skillItem.setLrgCtgr(skillItemDTO.getLrgCtgr());
        skillItem.setSmlCtgr(skillItemDTO.getSmlCtgr());
        skillItem.setSkillContent(skillItemDTO.getSkillContent());
        skillItem.setCreatedDttm(skillItemDTO.getCreatedDttm());
        skillItem.setUpdatedDttm(skillItemDTO.getUpdatedDttm());

        return skillItem;
    }

    public VSkillItemDTO VSkillItemToVSkillItemDto (VSkillItem vskillItem){

        if(vskillItem.equals(null)) return null;

        VSkillItemDTO vskillItemDTO = new VSkillItemDTO();
        vskillItemDTO.setItemPk(vskillItem.getItemPk());
        vskillItemDTO.setUser(vskillItem.getUser());
        vskillItemDTO.setSkillTitle(vskillItem.getSkillTitle());
        vskillItemDTO.setLrgCtgr(vskillItem.getLrgCtgr());
        vskillItemDTO.setSmlCtgr(vskillItem.getSmlCtgr());
        vskillItemDTO.setSkillContent(vskillItem.getSkillContent());
        vskillItemDTO.setCreatedDttm(vskillItem.getCreatedDttm());
        vskillItemDTO.setUpdatedDttm(vskillItem.getUpdatedDttm());

        return vskillItemDTO;
    }

    public List<VSkillItemDTO> VSkillItemListToVSkillItemDtoList (List<VSkillItem> vskillItemList){

        if(vskillItemList.size() == 0) return new ArrayList<VSkillItemDTO>();

        List<VSkillItemDTO> vskillItemDTOList = new ArrayList<VSkillItemDTO>();
        for(VSkillItem s : vskillItemList){
            VSkillItemDTO vskillItemDTO = new VSkillItemDTO();
            vskillItemDTO.setItemPk(s.getItemPk());
            vskillItemDTO.setUser(s.getUser());
            vskillItemDTO.setSkillTitle(s.getSkillTitle());
            vskillItemDTO.setLrgCtgr(s.getLrgCtgr());
            vskillItemDTO.setSmlCtgr(s.getSmlCtgr());
            vskillItemDTO.setSkillContent(s.getSkillContent());
            vskillItemDTO.setCreatedDttm(s.getCreatedDttm());
            vskillItemDTO.setUpdatedDttm(s.getUpdatedDttm());

            vskillItemDTOList.add(vskillItemDTO);
        }

        return vskillItemDTOList;

    }

    public VSkillItem VSkillItemDtoToVSkillItem (VSkillItemDTO vskillItemDTO){
        VSkillItem vskillItem = new VSkillItem();
        vskillItem.setItemPk(vskillItemDTO.getItemPk());
        vskillItem.setUser(vskillItemDTO.getUser());
        vskillItem.setSkillTitle(vskillItemDTO.getSkillTitle());
        vskillItem.setLrgCtgr(vskillItemDTO.getLrgCtgr());
        vskillItem.setSmlCtgr(vskillItemDTO.getSmlCtgr());
        vskillItem.setSkillContent(vskillItemDTO.getSkillContent());
        vskillItem.setCreatedDttm(vskillItemDTO.getCreatedDttm());
        vskillItem.setUpdatedDttm(vskillItemDTO.getUpdatedDttm());

        return vskillItem;
    }
}
