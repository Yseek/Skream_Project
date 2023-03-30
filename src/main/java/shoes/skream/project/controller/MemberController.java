package shoes.skream.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String save(@ModelAttribute MemberDTO memberDTO) {
		memberService.save(memberDTO);
		return "redirect:main";
	}

	@PostMapping("login.do")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		MemberDTO loginResult = memberService.login(memberDTO);
		if (loginResult != null) {
			session.setAttribute("loginEmail", loginResult.getEmail());
			session.setAttribute("loginName", loginResult.getName());
			return "redirect:main";
		} else {
			return "redirect:main";
		}
	}

	@GetMapping("logout.do")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
}