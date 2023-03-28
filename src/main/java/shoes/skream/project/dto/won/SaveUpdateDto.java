package shoes.skream.project.dto.won;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveUpdateDto {
    private final Long seq;
    private final String removeList;
    private final Integer category;
    private final String subject;
    private final String content;

    @Builder
    public SaveUpdateDto(Long seq, String removeList, Integer category, String subject, String content){
        this.seq = seq;
        this.removeList = removeList;
        this.category = category;
        this.subject = subject;
        this.content = content;
    }
}
