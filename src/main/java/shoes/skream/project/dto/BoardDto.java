package shoes.skream.project.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Boardfile;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.mapper.yun.BoardDtoMapper;

@Builder
@Data
public class BoardDto {

	private final long seq;
	private final Fileup file_up;
	private final String subject;
	private final String writer;
	private final LocalDateTime rdate;
	private final LocalDateTime udate;
	private final int hits;
	private final int recom;

	public static BoardDto from(Board board,BoardDtoMapper boardDtoMapper){
		Boardfile file = boardDtoMapper.selectBoardFile(board.getBoard_id());
		Fileup fileup = boardDtoMapper.selectFileup(file.getFileup_file_id());
		return BoardDto.builder()
		.seq(board.getBoard_id())
		.file_up(fileup)
		.subject(board.getSubject())
		.writer(board.getMember().getName())
		.rdate(board.getRdate())
		.udate(board.getUdate())
		.hits(board.getHits())
		.recom(board.getRecom())
		.build();
	}
}
