package shoes.skream.project.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WriteBoardDto {
    private final String subject;
	private final String content;
	private final Integer category;
	private final String member; 

    @Builder
    public WriteBoardDto(String subject, String content, Integer category, String member){
        this.subject = subject;
        this.content = content;
        this.category = category;
        this.member = member;
    }
}

