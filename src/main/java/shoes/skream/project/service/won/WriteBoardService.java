package shoes.skream.project.service.won;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.dto.WriteBoardDto;

public interface WriteBoardService {
    Board writeBoard(WriteBoardDto board);
    Fileup saveFile(MultipartFile multipartFile) throws IOException;
    void saveBoardfile(Board board, Fileup fileup);
}
