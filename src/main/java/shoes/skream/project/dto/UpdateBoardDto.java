package shoes.skream.project.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import shoes.skream.project.domain.Board;

@Getter
public class UpdateBoardDto {
    public final Long seq;
    private final Integer category;
    private final String subject;
    private final List<String> fileDirList;
    private final String content;

    @Builder
    public UpdateBoardDto(Long seq, Integer category, String subject, List<String> fileDirList, String content){
        this.seq = seq;
        this.category = category;
        this.subject = subject;
        this.fileDirList = fileDirList;
        this.content = content;
    }

    @Builder
    public static UpdateBoardDto from(Board board, List<String> fileDirList){
        return UpdateBoardDto.builder()
                .seq(board.getBoardId())
                .category(board.getCategory().getCategoryId())
                .subject(board.getSubject())
                .fileDirList(fileDirList)
                .content(board.getContent())
                .build();
    }
}
