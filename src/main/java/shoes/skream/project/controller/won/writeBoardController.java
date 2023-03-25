package shoes.skream.project.controller.won;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import shoes.skream.project.dto.WriteBoardDto;
import shoes.skream.project.service.won.WriteBoardService;

@Controller
public class WriteBoardController {
    @Autowired
    WriteBoardService service;

    @GetMapping("writeBoard")
    public String writeBoard(Model model){
        // TODO: 로그인한 멤버의 email를 인자로 받아서 넘기도록 수정한다
        String email = "abc1@naver.com";
        model.addAttribute("email", email);
        return "writeBoard";
    }

    @PostMapping("writeBoard")
    public String writeBoardTest(WriteBoardDto board, @RequestParam("file") List<MultipartFile> files){
        // BOARD write
        System.out.println("board: " + board);
        System.out.println("category: " + board.getCategory());
        // request에서 category, member
        service.write(board);


        //멀티 파일 넘어오는지 체크
        for (MultipartFile multipartFile : files) {
            System.out.println("multipartFile:" + multipartFile);
        }
        return "redirect:board";
    }

    @GetMapping("updateBoard")
    public String updateBoard(){
        return "updateBoard";
    }
}
