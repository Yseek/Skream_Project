package shoes.skream.project.service.yun;

import shoes.skream.project.domain.Comment;
import shoes.skream.project.domain.Recomment;

public interface CommentsServiceInterface {
	void writeComment(Comment comment);
	void writeReComment(Recomment recomment);
	void deleteComment(long commentId);
	void deleteReComment(long recommentId);
}
