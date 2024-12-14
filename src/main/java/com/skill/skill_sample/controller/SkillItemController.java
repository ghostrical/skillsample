package com.skill.skill_sample.controller;

import com.skill.skill_sample.dto.SkillItemDTO;
import com.skill.skill_sample.dto.VSkillItemDTO;
import com.skill.skill_sample.service.SkillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// View Resolver 필요함.

@Controller
@RequestMapping("/skill") // return 내용은 여기 requestmapping 이랑 같으면 안됨. 어차피 뷰리졸버 sufix하면 되지도 않겠지만.
public class SkillItemController {
    @Autowired
    private SkillItemService skillItemService;

    // 전체 조회
//    @GetMapping
//    public String getAllSkills(Model model) {
//        List<SkillItemDTO> skills = skillItemService.getAllSkills();
//        model.addAttribute("skills", skills);
//        return "skill_main.html"; // Thymeleaf 템플릿 파일 이름
//    }

    //View
    @GetMapping
    public String getAllSkills(Model model) {
        List<VSkillItemDTO> skills = skillItemService.getAllSkills();
        model.addAttribute("skills", skills);
        return "skill_main.html"; // Thymeleaf 템플릿 파일 이름
    }

    // 단일 조회
//    @GetMapping("/{itemPk}")
//    public String getSkillById(@PathVariable("itemPk") int itemPk, Model model) {
//        SkillItemDTO skill = skillItemService.getSkillById(itemPk);
//        model.addAttribute("skill", skill);
//        return "skill_detail.html"; // 상세정보 뷰
//    }

    //view
    @GetMapping("/{itemPk}")
    public String getSkillById(@PathVariable("itemPk") int itemPk, Model model) {
        VSkillItemDTO skill = skillItemService.getSkillById(itemPk);
        model.addAttribute("skill", skill);
        return "skill_detail.html"; // 상세정보 뷰
    }

    // 데이터 추가
//    @GetMapping("/new")
//    public String addSkillForm(Model model) {
//        model.addAttribute("skillItemDTO", new SkillItemDTO());
//        return "skill_new"; // 추가 뷰
//    }

    // view
    @GetMapping("/new")
    public String addSkillForm(Model model) {
        model.addAttribute("skillItemDTO", new VSkillItemDTO());
        return "skill_new"; // 추가 뷰
    }

    @PostMapping
    public String addSkill(@ModelAttribute SkillItemDTO skillItemDTO) {

        // 프론트에서 데이터 왔는가?
        System.out.println("getItemPk : "+skillItemDTO.getItemPk());
        System.out.println("getLrgCtgr : "+skillItemDTO.getLrgCtgr());
        System.out.println("getSkillTitle : "+skillItemDTO.getSkillTitle());
        System.out.println("getSkillContent : "+skillItemDTO.getSkillContent());
        // 값 나온다. 데이터는 왔다는 소리.

        skillItemService.addSkill(skillItemDTO);
        return "redirect:/skill"; // 메인 리스트 화면으로 리다이렉트
    }

    // view 뷰를 왜 add 하냐
//    @PostMapping
//    public String addSkill(@ModelAttribute VSkillItemDTO vskillItemDTO) {
//
//        // 프론트에서 데이터 왔는가?
//        System.out.println("getItemPk : "+vskillItemDTO.getItemPk());
//        System.out.println("getLrgCtgr : "+vskillItemDTO.getLrgCtgr());
//        System.out.println("getSkillTitle : "+vskillItemDTO.getSkillTitle());
//        System.out.println("getSkillContent : "+vskillItemDTO.getSkillContent());
//        // 값 나온다. 데이터는 왔다는 소리.
//
//        skillItemService.addSkill(vskillItemDTO);
//        return "redirect:/skill"; // 메인 리스트 화면으로 리다이렉트
//    }

    // 데이터 수정
//    @GetMapping("/mod/{itemPk}")
//    public String updateSkillForm(@PathVariable("itemPk") int itemPk, Model model) {
//
//        System.out.println("설마 여기로 오냐?");
//        SkillItemDTO skill = skillItemService.getSkillById(itemPk);
//        model.addAttribute("skillItemDTO", skill);
//        return "skill_mod"; // 수정 뷰
//    }

    // view
    @GetMapping("/mod/{itemPk}")
    public String updateSkillForm(@PathVariable("itemPk") int itemPk, Model model) {

        System.out.println("설마 여기로 오냐?");
        VSkillItemDTO skill = skillItemService.getSkillById(itemPk);
        model.addAttribute("skillItemDTO", skill);
        return "skill_mod"; // 수정 뷰
    }

    @PatchMapping("/mod/{itemPk}")
    public String updateSkill(@PathVariable("itemPk") int itemPk, @ModelAttribute SkillItemDTO skillItemDTO) {

        System.out.println("여기 오긴 했냐?");
        System.out.println("itemPk : "+itemPk);
        System.out.println("getSkillTitle"+skillItemDTO.getSkillTitle());
        System.out.println("getLrgCtgr"+skillItemDTO.getLrgCtgr());
        System.out.println("getSkillContent"+skillItemDTO.getSkillContent());

        skillItemService.updateSkill(itemPk, skillItemDTO);
        return "redirect:/skill"; // 메인 리스트 화면으로 리다이렉트
    }

    // view 뷰를 왜 update 하냐
//    @PatchMapping("/mod/{itemPk}")
//    public String updateSkill(@PathVariable("itemPk") int itemPk, @ModelAttribute VSkillItemDTO vskillItemDTO) {
//
//        System.out.println("여기 오긴 했냐?");
//        System.out.println("itemPk : "+itemPk);
//        System.out.println("getSkillTitle"+vskillItemDTO.getSkillTitle());
//        System.out.println("getLrgCtgr"+vskillItemDTO.getLrgCtgr());
//        System.out.println("getSkillContent"+vskillItemDTO.getSkillContent());
//
//        skillItemService.updateSkill(itemPk, vskillItemDTO);
//        return "redirect:/skill"; // 메인 리스트 화면으로 리다이렉트
//    }

}