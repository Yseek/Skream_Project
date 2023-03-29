package shoes.skream.project.controller.hyun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shoes.skream.project.dto.BoardDto;
import shoes.skream.project.service.yun.BoardServiceInterface;

@Controller
public class MainController {

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

	@GetMapping("memberUpdate")
	public String memberUpdate() {
		return "memberUpdate";
	}
}
