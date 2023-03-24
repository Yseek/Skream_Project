package shoes.skream.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("content")
	public String content(){
		return "content";
	}

	@GetMapping("board")
	public String board(){
		return "board";
	}
}
