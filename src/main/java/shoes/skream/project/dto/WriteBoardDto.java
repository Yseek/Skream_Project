package shoes.skream.project.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Category;

//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class WriteBoardDto {
    private final String subject;
	private final String content;
	private final String category;
	private final String member; 

    @Builder
    public WriteBoardDto(String subject, String content, String category, String member){
        this.subject = subject;
        this.content = content;
        this.category = category;
        this.member = member;
    }
    /* public Board toEntity(){
        Board board = Board.Builder()
        .subject(subject)
        .content(content)
        .category(Category.get)
        return board;
    } */
}

