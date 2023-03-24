package shoes.skream.project.controller.won;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class writeBoardController {
    @GetMapping("writeBoard")
    public String writeBoard(){
        return "writeBoard";
    }

    @ResponseBody
    @PostMapping("writeBoard")
    public String writeBoardTest(HttpServletRequest request, @RequestParam("file") List<MultipartFile> files){
        Enumeration<String> list = request.getParameterNames();
        while(list.hasMoreElements()){
            String name = (String) list.nextElement();
            System.out.println("###name: " + name);
        }
        for (MultipartFile multipartFile : files) { //멀티 파일
            System.out.println("multipartFile:" + multipartFile);
        }      
        return "test page";
    }
}
