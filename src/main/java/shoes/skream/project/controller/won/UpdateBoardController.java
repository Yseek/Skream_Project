package shoes.skream.project.controller.won;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import shoes.skream.project.domain.Category;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.dto.won.UpdateBoardDto;
import shoes.skream.project.service.won.UpdateBoardService;
import shoes.skream.project.service.won.WriteBoardService;

@Slf4j
@Controller
public class UpdateBoardController {
    @Autowired
    UpdateBoardService updateBoardService;
    @Autowired
    WriteBoardService writeBoardService;

    @GetMapping("updateBoard/{id}")
    public String updateBoard(@PathVariable Long id, Model model){
        List<Category> categoryList = writeBoardService.getCategoryList();       
        model.addAttribute("categoryList", categoryList);
        UpdateBoardDto updateBoardDto = updateBoardService.getBoard(id);
        model.addAttribute("updateBoardDto", updateBoardDto);
        log.info("$$$$ 파일리스트의 첫번째 파일 이름: {}", updateBoardDto.getFileList().get(0).getOrgnm());
        return "updateBoard";
    }

    @GetMapping("/uploadedimages/{fileId}")
    @ResponseBody
    public org.springframework.core.io.Resource showImage(@PathVariable("fileId") Long fileId, Model model) 
            throws IOException{
        Fileup fileup = updateBoardService.getFileup(fileId);
        return new UrlResource("file:" + fileup.getSavedpath());
    }

    @PostMapping("updateBoard/{id}")
    public String saveUpdateBoard(UpdateBoardDto updateBoardDto, @RequestParam("file") List<MultipartFile> files)
                throws IOException{
        log.info("$$$$ saveUpdateDto: {}", updateBoardDto.getRemoveList());
        // board update
        updateBoardService.updateBoard(updateBoardDto);
        // 새로 업로드 fileup, boardfile insert

        // 이전 업로드 지울 경우 delete

        return "redirect:content";
    }
}
