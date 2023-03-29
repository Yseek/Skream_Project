package shoes.skream.project.dto.won;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Fileup;

@Getter
public class UpdateBoardDto {
    public final Long seq;
    private final Integer category;
    private final String subject;
    private final List<Fileup> fileList;
    private final String content;
    private final String removeList;

    @Builder
    public UpdateBoardDto(Long seq, Integer category, String subject, List<Fileup> fileList, String content, String removeList){
        this.seq = seq;
        this.category = category;
        this.subject = subject;
        this.fileList = fileList;
        this.content = content;
        this.removeList = removeList;
    }

    @Builder
    public static UpdateBoardDto from(Board board, List<Fileup> fileList){
        return UpdateBoardDto.builder()
                .seq(board.getBoardId())
                .category(board.getCategory().getCategoryId())
                .subject(board.getSubject())
                .fileList(fileList)
                .content(board.getContent())
                .build();
    }
}
