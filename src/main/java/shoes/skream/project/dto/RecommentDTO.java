package shoes.skream.project.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import shoes.skream.project.domain.Recomment;
import shoes.skream.project.mapper.yun.BoardDtoMapper;

@Builder
@Data
public class RecommentDTO {
	private final long commentId;
	private final long recommentId;
	private final String email;
	private final String recommentWriter;
	private final LocalDateTime rdate;
	private final LocalDateTime udate;
	private final String recoContext;

	public static RecommentDTO from(Recomment recomment ,BoardDtoMapper boardDtoMapper){
		return RecommentDTO.builder()
		.commentId(recomment.getCommentId())
		.email(recomment.getEmail())
		.recommentId(recomment.getRecommentId())
		.recommentWriter(boardDtoMapper.selectMember(recomment.getEmail()).getName())
		.rdate(recomment.getRdate())
		.udate(recomment.getUdate())
		.recoContext(recomment.getRecoContent())
		.build();
	}
}
