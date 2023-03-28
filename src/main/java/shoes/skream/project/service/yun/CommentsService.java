package shoes.skream.project.service.yun;

import org.springframework.beans.factory.annotation.Autowired;

import shoes.skream.project.domain.Comment;
import shoes.skream.project.domain.Recomment;
import shoes.skream.project.repository.yun.CommentRepository;
import shoes.skream.project.repository.yun.RecommentRepository;

public class CommentsService implements CommentsServiceInterface {
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	RecommentRepository recommentRepository;


	
	public CommentsService(CommentRepository commentRepository,RecommentRepository recommentRepository) {
		this.commentRepository = commentRepository;
		this.recommentRepository = recommentRepository;
	}

	@Override
	public void writeComment(Comment comment) {
		comment.setBoardId(comment.getBoardId());
		comment.setCommentId(comment.getCommentId());
		comment.setCoContent(comment.getCoContent());
		comment.setEmail(comment.getEmail());
		commentRepository.save(comment);
	}

	@Override
	public void writeReComment(Recomment recomment) {
		recomment.setCommentId(recomment.getCommentId());
		recomment.setRecommentId(recomment.getRecommentId());
		recomment.setEmail(recomment.getEmail());
		recomment.setRecoContent(recomment.getRecoContent());
		recommentRepository.save(recomment);
	}

	@Override
	public void deleteComment(long commentId) {
		commentRepository.deleteById(commentId);
	}

	@Override
	public void deleteReComment(long recommentId) {
		recommentRepository.deleteById(recommentId);
	}
}
