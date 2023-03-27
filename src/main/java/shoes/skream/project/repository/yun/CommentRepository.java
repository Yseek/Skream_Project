package shoes.skream.project.repository.yun;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{
	List<Comment> findByBoardId(long boardId);
}
