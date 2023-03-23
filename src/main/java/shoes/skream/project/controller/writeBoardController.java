package shoes.skream.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class writeBoardController {
    @GetMapping("write")
    public String writeBoard(){
        return "writeBoard";
    }
}
