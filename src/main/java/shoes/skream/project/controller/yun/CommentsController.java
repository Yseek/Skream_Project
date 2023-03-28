package shoes.skream.project.controller.yun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shoes.skream.project.domain.Comment;
import shoes.skream.project.domain.Recomment;
import shoes.skream.project.service.yun.CommentsServiceInterface;

@Controller
public class CommentsController {

	@Autowired
	CommentsServiceInterface commentsServiceInterface;

	@PostMapping("commentWrite")
	public String commentWrite(Comment comment){
		commentsServiceInterface.writeComment(comment);
		return "redirect:boardlist";
	}
	
	@PostMapping("recommentWrite")
	public String recommentWrite(Recomment recomment){
		commentsServiceInterface.writeReComment(recomment);
		return "redirect:boardlist";
	}

	@PostMapping("deletComment")
	public String deletComment(long commentId){
		commentsServiceInterface.deleteComment(commentId);
		return "redirect:boardlist";
	}

	@PostMapping("deletReComment")
	public String deletReComment(long recommentId){
		commentsServiceInterface.deleteReComment(recommentId);
		return "redirect:boardlist";
	}
}
