package shoes.skream.project.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Boardfile;
import shoes.skream.project.domain.Category;
import shoes.skream.project.domain.Comment;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.domain.Recommend;
import shoes.skream.project.domain.Recomment;
import shoes.skream.project.mapper.yun.BoardDtoMapper;

@Builder
@Data
public class BoardDto {

	private final long seq;
	private final List<Fileup> fileUp;
	private final String subject;
	private final String writer;
	private final String contents;
	private final LocalDateTime rdate;
	private final LocalDateTime udate;
	private final int hits;
	private final int recom;
	private final Category cg;
	private final List<Comment> comments;
	private final List<List<Recomment>> recomlist;
	private final List<Recommend> recommends;
	private final List<String> recommendsEmail;
	private final String email;

	public static BoardDto from(Board board, BoardDtoMapper boardDtoMapper) {
		List<Boardfile> files = boardDtoMapper.selectBoardFile(board.getBoardId());
		List<Fileup> fileup = new ArrayList<>();
		List<Comment> comments = boardDtoMapper.selectComments(board.getBoardId());
		List<List<Recomment>> recomlist = new ArrayList<>();
		List<Recommend> recommends = boardDtoMapper.listRecommend(board.getBoardId());
		List<String> recommendsEmail = new ArrayList<>();
		for(Recommend reco :recommends){
			recommendsEmail.add(reco.getEmail());
		}
		for (Comment name : comments) {
			recomlist.add(boardDtoMapper.listRecomment(name.getCommentId()));
		}
		for (Boardfile fileContent : files) {
			fileup.add(boardDtoMapper.selectFileup(fileContent.getFileupFileId()));
		}
		return BoardDto.builder()
				.seq(board.getBoardId())
				.fileUp(fileup)
				.subject(board.getSubject())
				.writer(board.getMember().getName())
				.contents(board.getContent())
				.rdate(board.getRdate())
				.udate(board.getUdate())
				.hits(board.getHits())
				.recom(board.getRecom())
				.cg(board.getCategory())
				.comments(comments)
				.recomlist(recomlist)
				.recommends(recommends)
				.recommendsEmail(recommendsEmail)
				.email(board.getMember().getEmail())
				.build();
	}
}
