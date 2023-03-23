package shoes.skream.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class writeBoardController {
    @GetMapping("write")
    public String writeBoard(){
        return "writeBoard";
    }

    @PostMapping("write")
    public String writeBoardTest(){
        return "";
    }
}
