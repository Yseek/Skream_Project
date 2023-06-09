package shoes.skream.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import shoes.skream.project.domain.Category;
import shoes.skream.project.dto.won.WriteBoardDto;
import shoes.skream.project.service.won.WriteBoardService;

@Controller
public class WriteBoardController {
	@Autowired
	WriteBoardService writeBoardService;

	@GetMapping("writeBoard")
	public String writeBoard(HttpServletRequest request, HttpSession session, Model model) {
		List<Category> categoryList = writeBoardService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		session = request.getSession();
		String loginUser = (String)session.getAttribute("loginEmail");
		if(loginUser == null){
			return "redirect:main";
		}
		return "writeBoard";
	}

	@Transactional
	@PostMapping("writeBoard")
	public String writeBoardTest(WriteBoardDto boardDto, @RequestParam("file") List<MultipartFile> files)
			throws IOException {
		long boardId = writeBoardService.writeBoard(boardDto);

		for (MultipartFile file : files) {
			long fileupId = writeBoardService.saveFile(file);
			writeBoardService.saveBoardfile(boardId, fileupId);
		}
		return "redirect:boardlist";
	}
}
