package shoes.skream.project.controller.hoya;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import shoes.skream.project.dto.hoya.MemberDTO;
import shoes.skream.project.service.hoya.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {
  private final MemberService memberService;

  @PostMapping("join.do")
  public String save(@ModelAttribute MemberDTO memberDTO){
    memberService.save(memberDTO);
    return "main";
  }
}
