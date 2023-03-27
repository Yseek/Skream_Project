package shoes.skream.project.service.won;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.domain.Member;
import shoes.skream.project.dto.WriteBoardDto;

public interface WriteBoardService {
    Member getMember(String email);
    long writeBoard(WriteBoardDto board);
    long saveFile(MultipartFile multipartFile) throws IOException;
    void saveBoardfile(long boardId, long fileupId);
}
