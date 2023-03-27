package shoes.skream.project.controller.won;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;
import shoes.skream.project.dto.BoardDto;
import shoes.skream.project.service.won.UpdateBoardService;

@Slf4j
@Controller
public class UpdateBoardController {
    @Autowired
    UpdateBoardService updateBoardService;

    @GetMapping("updateBoard/{id}")
    public String updateBoard(@PathVariable Long id, Model model){
        BoardDto boardDto = updateBoardService.getBoard(id);
        model.addAttribute("boardDto", boardDto);
        log.info("boardDto: {}", boardDto);
        return "updateBoard";
    }
}
