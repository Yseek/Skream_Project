package shoes.skream.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import shoes.skream.project.dto.BoardDto;
import shoes.skream.project.dto.hoya.MemberDTO;
import shoes.skream.project.service.hoya.MemberService;
import shoes.skream.project.service.yun.BoardServiceInterface;

@RequiredArgsConstructor
@Controller
public class MainController {

	private final MemberService memberService;

	@Autowired
	BoardServiceInterface boardServiceInterface;

	@GetMapping("main")
	public String main(Model model,
			@PageableDefault(page = 0, size = 10, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<BoardDto> listhits = boardServiceInterface.listByView(pageable);
		int nowPagehits = listhits.getPageable().getPageNumber() + 1;

		model.addAttribute("orderbyhits", "hits");
		model.addAttribute("listhits", listhits);
		model.addAttribute("nowPagehits", nowPagehits);

		Page<BoardDto> listrecom = boardServiceInterface.listByRecom(pageable);
		int nowPagerecom = listrecom.getPageable().getPageNumber() + 1;

		model.addAttribute("orderbyrecom", "recom");
		model.addAttribute("listrecom", listrecom);
		model.addAttribute("nowPagerecom", nowPagerecom);

		Page<BoardDto> list = boardServiceInterface.list(pageable);
		int nowPage = list.getPageable().getPageNumber() + 1;

		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		return "main";

	}

	/**
	 * 회원 정보 페이지 진입
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("memberUpdate")
	public String memberUpdate(HttpSession session, Model model) {

		String email = (String) session.getAttribute("loginEmail");
		MemberDTO member = new MemberDTO();

		member.setEmail(email);

		member = memberService.member(email);

		model.addAttribute("member", member);
		return "memberUpdate";
	}

	/**
	 * 회원 정보 업데이트
	 * 
	 * @param memberDto
	 * @param model
	 * @return
	 */
	@PostMapping("memberUpdate")
	public String memberUpdatePost(MemberDTO memberDto, Model model) {

		int result = memberService.memberUpdatePost(memberDto);

		MemberDTO member = new MemberDTO();

		if (result == 1) {
			member = memberService.member(memberDto.getEmail());
			System.out.println("회원 수정 성공");
		} else {
			System.out.println("회원 수정 실패");
		}

		model.addAttribute("member", member);

		return "redirect:main";
	}

	@PostMapping("memberDelete")
	public String memberDelete(String email, HttpSession session) {
		memberService.memberDelete(email);
		session.invalidate();
		MemberController.loginUsers.remove(session.getId());
		return "redirect:main";
	}

}
