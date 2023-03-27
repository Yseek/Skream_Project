package shoes.skream.project.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import shoes.skream.project.domain.Comment;
import shoes.skream.project.domain.Recomment;
import shoes.skream.project.mapper.yun.BoardDtoMapper;

@Builder
@Data
public class CommentDTO {
	private final long commentId;
	private final long boardId;
	private final String email;
	private final LocalDateTime rdate;
	private final LocalDateTime udate;
	private final String coContext;
	private final String commentwriter;
	private final List<RecommentDTO> recomments;

	public static CommentDTO from(Comment comment, BoardDtoMapper boardmDtoMapper){

		List<RecommentDTO> recomments = new ArrayList<>();
		for(Recomment recom :boardmDtoMapper.listRecommnet(comment.getCommentId())){
			recomments.add(RecommentDTO.from(recom, boardmDtoMapper));
		}
		return CommentDTO.builder()
		.commentId(comment.getCommentId())
		.boardId(comment.getBoardId())
		.email(comment.getEmail())
		.rdate(comment.getRdate())
		.udate(comment.getUdate())
		.coContext(comment.getCoContent())
		.commentwriter(boardmDtoMapper.selectMember(comment.getEmail()).getName())
		.recomments(recomments)
		.build();
	}
}
