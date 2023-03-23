package shoes.skream.project.controller.yun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shoes.skream.project.service.yun.BoardServiceInterface;

@Controller
public class BoardController {

	@Autowired
	BoardServiceInterface boardServiceInterface;

	@GetMapping("content")
	public String content(){
		return "content";
	}

	@GetMapping("board")
	public String board(Model model, Pageable pageable){
		model.addAttribute("list", boardServiceInterface.list(pageable).getContent());
		return "board";
	}
}
