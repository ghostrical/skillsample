package com.skill.skill_sample.service;

import com.skill.skill_sample.dto.SkillItemDTO;
import com.skill.skill_sample.dto.VSkillItemDTO;
import com.skill.skill_sample.entity.SkillItem;
import com.skill.skill_sample.entity.VSkillItem;
import com.skill.skill_sample.mapper.EntityDtoMapper;
import com.skill.skill_sample.repository.SkillItemRepository;
import com.skill.skill_sample.repository.VSkillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// Mapper 가 필요할거다.
@Service
public class SkillItemService {
    @Autowired
    private SkillItemRepository skillItemRepository;

    @Autowired
    private VSkillItemRepository vskillItemRepository;

    @Autowired
    private EntityDtoMapper entityDtoMapper;

//    public List<SkillItemDTO> getAllSkills() {
//
//        List<SkillItemDTO> skillItemDTOS = new ArrayList<>();
//
//        System.out.println("1");
//
//        List<SkillItem> skillItems = skillItemRepository.findAll();
//
//        System.out.println("skillItems");
//        System.out.println(skillItems);
//
//        if(skillItems.size() != 0) {
//            for (SkillItem skillItem : skillItems) {
//                SkillItemDTO skillItemDTO = new SkillItemDTO();
//                skillItemDTO.setItemPk(skillItem.getItemPk());
//                skillItemDTO.setSkillContent(skillItem.getSkillContent());
//                skillItemDTO.setCreatedDttm(skillItem.getCreatedDttm());
//                skillItemDTO.setSkillTitle(skillItem.getSkillTitle());
//                skillItemDTO.setLrgCtgr(skillItem.getLrgCtgr());
//                skillItemDTO.setSmlCtgr(skillItem.getSmlCtgr());
//                skillItemDTO.setUpdatedDttm(skillItem.getUpdatedDttm());
//                skillItemDTO.setUser(skillItem.getUser());
//                skillItemDTOS.add(skillItemDTO);
//            }
//        }
//
//        System.out.println("skillItemDTOS");
//        System.out.println(skillItemDTOS);
//
//        return skillItemDTOS;
//    }

    // View
    public List<VSkillItemDTO> getAllSkills() {

        List<VSkillItemDTO> skillItemDTOS = new ArrayList<>();

        System.out.println("1");

        List<VSkillItem> skillItems = vskillItemRepository.findAll();

        System.out.println("skillItems");
        System.out.println(skillItems);

        skillItemDTOS = entityDtoMapper.VSkillItemListToVSkillItemDtoList(skillItems);

        System.out.println("skillItemDTOS");
        System.out.println(skillItemDTOS);

        return skillItemDTOS;
    }

//    public SkillItemDTO getSkillById(int itemPk) {
//
//        SkillItemDTO skillItemDTO = new SkillItemDTO();
//
//        SkillItem skillItem = skillItemRepository.findById(itemPk).orElse(null);
//
//        if(!skillItem.equals(null)){
//            skillItemDTO.setItemPk(skillItem.getItemPk());
//            skillItemDTO.setSkillTitle(skillItem.getSkillTitle());
//            skillItemDTO.setSkillContent(skillItem.getSkillContent());
//            skillItemDTO.setUser(skillItem.getUser());
//            skillItemDTO.setUpdatedDttm(skillItem.getUpdatedDttm());
//            skillItemDTO.setSmlCtgr(skillItem.getSmlCtgr());
//            skillItemDTO.setLrgCtgr(skillItem.getLrgCtgr());
//            skillItemDTO.setCreatedDttm(skillItem.getCreatedDttm());
//        }
//
//        return skillItemDTO;
//    }

    // view
    public VSkillItemDTO getSkillById(int itemPk) {

        VSkillItemDTO vskillItemDTO = new VSkillItemDTO();

        VSkillItem vskillItem = vskillItemRepository.findById(itemPk).orElse(null);

        vskillItemDTO = entityDtoMapper.VSkillItemToVSkillItemDto(vskillItem);

        return vskillItemDTO;
    }

    public void addSkill(SkillItemDTO skillItemDTO) {
        SkillItem skillItem = new SkillItem();
        // Set properties from DTO to Entity 병신같이 이렇게 하니깐 당연히 안들어가지...

        // 일단 이거로 시간 맞추고, 추후에 그 이전에 영상에서 봤던 DB 타임 맞추는거로 해보자.
        skillItem.setSkillTitle(skillItemDTO.getSkillTitle());
        skillItem.setSkillContent(skillItemDTO.getSkillContent());
        skillItem.setUser("GHOST"); // 현재 유저는 나혼자니깐 고정
        skillItem.setLrgCtgr(skillItemDTO.getLrgCtgr());
        skillItem.setSmlCtgr(skillItemDTO.getSmlCtgr());

        Date date = new Date();
        skillItem.setCreatedDttm(date); // 자바서버상 날짜시간임.
        skillItem.setUpdatedDttm(date);

        skillItemRepository.save(skillItem);
    }

    //view 뷰를 왜 add하냐
//    public void addSkill(VSkillItemDTO vskillItemDTO) {
//        VSkillItem vskillItem = new VSkillItem();
//        // Set properties from DTO to Entity 병신같이 이렇게 하니깐 당연히 안들어가지...
//
//        vskillItem = entityDtoMapper.VSkillItemDtoToVSkillItem(vskillItemDTO);
//
//        vskillItem.setUser("GHOST");
//        Date date = new Date();
//        vskillItem.setCreatedDttm(date); // 자바서버상 날짜시간임.
//        vskillItem.setUpdatedDttm(date);
//
//        vskillItemRepository.save(vskillItem);
//    }

    public void updateSkill(int itemPk, SkillItemDTO skillItemDTO) {
        SkillItem skillItem = skillItemRepository.findById(itemPk).orElse(null);
        // Update properties from DTO to Entity

//        Coffee findCoffee = findVerifiedCoffee(coffee.getCoffeeId());

//        Optional.ofNullable(coffee.getKorName())
//                .ifPresent(korName -> findCoffee.setKorName(korName));
//        Optional.ofNullable(coffee.getEngName())
//                .ifPresent(engName -> findCoffee.setEngName(engName));
//        Optional.ofNullable(coffee.getPrice())
//                .ifPresent(price -> findCoffee.setPrice(price));

        Optional.ofNullable(skillItemDTO.getLrgCtgr())
                .ifPresent(lrgCtgr -> skillItem.setLrgCtgr(lrgCtgr));
        Optional.ofNullable(skillItemDTO.getSmlCtgr())
                .ifPresent(smlCtgr -> skillItem.setSmlCtgr(smlCtgr));
        Optional.ofNullable(skillItemDTO.getSkillTitle())
                .ifPresent(skillTitle -> skillItem.setSkillTitle(skillTitle));
        Optional.ofNullable(skillItemDTO.getSkillContent())
                .ifPresent(skillContent -> skillItem.setSkillContent(skillContent));

        Date date = new Date();
        skillItem.setUpdatedDttm(date);

        skillItemRepository.save(skillItem);
    }

    //view 뷰를 왜 update한야
//    public void updateSkill(int itemPk, VSkillItemDTO vskillItemDTO) {
//        VSkillItem vskillItem = vskillItemRepository.findById(itemPk).orElse(null);
//        // Update properties from DTO to Entity
//
////        Coffee findCoffee = findVerifiedCoffee(coffee.getCoffeeId());
//
////        Optional.ofNullable(coffee.getKorName())
////                .ifPresent(korName -> findCoffee.setKorName(korName));
////        Optional.ofNullable(coffee.getEngName())
////                .ifPresent(engName -> findCoffee.setEngName(engName));
////        Optional.ofNullable(coffee.getPrice())
////                .ifPresent(price -> findCoffee.setPrice(price));
//
//        Optional.ofNullable(vskillItemDTO.getLrgCtgr())
//                .ifPresent(lrgCtgr -> vskillItem.setLrgCtgr(lrgCtgr));
//        Optional.ofNullable(vskillItemDTO.getSmlCtgr())
//                .ifPresent(smlCtgr -> vskillItem.setSmlCtgr(smlCtgr));
//        Optional.ofNullable(vskillItemDTO.getSkillTitle())
//                .ifPresent(skillTitle -> vskillItem.setSkillTitle(skillTitle));
//        Optional.ofNullable(vskillItemDTO.getSkillContent())
//                .ifPresent(skillContent -> vskillItem.setSkillContent(skillContent));
//
//        Date date = new Date();
//        vskillItem.setUpdatedDttm(date);
//
//        vskillItemRepository.save(vskillItem);
//    }
}