package shoes.skream.project.controller.yun;

import javax.servlet.http.HttpServletRequest;

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
	public String commentWrite(Comment comment, HttpServletRequest request){
		commentsServiceInterface.writeComment(comment);
		return "redirect:" + request.getHeader("Referer");
	}
	
	@PostMapping("recommentWrite")
	public String recommentWrite(Recomment recomment,HttpServletRequest request){
		commentsServiceInterface.writeReComment(recomment);
		return "redirect:" + request.getHeader("Referer");
	}

	@PostMapping("deletComment")
	public String deletComment(long commentId,HttpServletRequest request){
		commentsServiceInterface.deleteComment(commentId);
		return "redirect:" + request.getHeader("Referer");
	}

	@PostMapping("deletReComment")
	public String deletReComment(long recommentId,HttpServletRequest request){
		commentsServiceInterface.deleteReComment(recommentId);
		return "redirect:" + request.getHeader("Referer");
	}
}
