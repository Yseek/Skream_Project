package shoes.skream.project.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import shoes.skream.project.dto.hoya.MemberDTO;
import shoes.skream.project.service.hoya.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	Map<String, String> loginUsers = new HashMap<>();

	@PostMapping("join.do")
	public String save(@ModelAttribute MemberDTO memberDTO) {
		memberService.save(memberDTO);
		return "redirect:main";
	}

	@PostMapping("login.do")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, RedirectAttributes request) {
		MemberDTO loginResult = memberService.login(memberDTO);
		if (loginResult != null) {
			session.setAttribute("loginEmail", loginResult.getEmail());
			session.setAttribute("loginName", loginResult.getName());
			loginUsers.put(session.getId(), loginResult.getName());
			return "redirect:main?";
		} else {
			request.addFlashAttribute("check", 1);
			return "redirect:main?";
		}
	}

	@GetMapping("logout.do")
	public String Logout(HttpSession session) {
		session.invalidate();
		loginUsers.remove(session.getId());
		return "redirect:main?";
	}

	@GetMapping("loginUserCheck")
	@ResponseBody
	public Collection<String> loginUserCheck() {
		return loginUsers.values();
	}
}