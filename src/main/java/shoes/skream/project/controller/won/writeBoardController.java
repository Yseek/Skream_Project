package shoes.skream.project.controller.won;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.dto.WriteBoardDto;
import shoes.skream.project.service.won.WriteBoardService;

@Slf4j
@Controller
public class WriteBoardController {
    @Autowired
    WriteBoardService writeBoardService;

    @GetMapping("writeBoard")
    public String writeBoard(Model model){
        // TODO: 로그인한 멤버의 email를 인자로 받아서 넘기도록 수정한다
        String email = "abc1@naver.com";
        model.addAttribute("email", email);
        return "writeBoard";
    }

    @PostMapping("writeBoard")
    public String writeBoardTest(WriteBoardDto boardDto, @RequestParam("file") List<MultipartFile> files)
                throws IOException{
        // BOARD insert
        Board board = writeBoardService.writeBoard(boardDto);
        //Fileup fileup = new Fileup();

        // Fileup table insert
        for (MultipartFile file : files) {
            if(file.isEmpty()){
                log.info("$$$$$ file.isEmpty() in log");
                break;
            }
            Fileup fileup = writeBoardService.saveFile(file);
            log.info("$$$$$ Board: {}, Fileup: {}", board, fileup);
            // Boardfile insert
            // board.save 와 fileup.save 의 return 값을 이용해 boardfile.save
            writeBoardService.saveBoardfile(board, fileup);
        }

        return "redirect:board";
    }

    @GetMapping("updateBoard")
    public String updateBoard(){
        return "updateBoard";
    }
}
