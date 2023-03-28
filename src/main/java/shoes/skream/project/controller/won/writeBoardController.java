package shoes.skream.project.controller.won;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import shoes.skream.project.dto.WriteBoardDto;
import shoes.skream.project.service.won.WriteBoardService;

@Slf4j
@Controller
public class WriteBoardController {
    @Autowired
    WriteBoardService writeBoardService;

    @GetMapping("writeBoard")
    public String writeBoard(HttpSession session){
        String loginUser = writeBoardService.getMember("yun@naver.com").getEmail();
        log.info("#### loginUser: {}", loginUser);
        session.setAttribute("loginUser", loginUser);
        return "writeBoard";
    }

    @Transactional
    @PostMapping("writeBoard")
    public String writeBoardTest(WriteBoardDto boardDto, @RequestParam("file") List<MultipartFile> files)
                throws IOException{
        long boardId = writeBoardService.writeBoard(boardDto);

        for (MultipartFile file : files) {
            long fileupId = writeBoardService.saveFile(file);
            writeBoardService.saveBoardfile(boardId, fileupId);
        }
        return "redirect:boardlist";
    }
}
