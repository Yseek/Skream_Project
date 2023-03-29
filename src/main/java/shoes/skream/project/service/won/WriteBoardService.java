package shoes.skream.project.service.won;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import shoes.skream.project.domain.Category;
import shoes.skream.project.domain.Member;
import shoes.skream.project.dto.won.WriteBoardDto;

public interface WriteBoardService {
    List<Category> getCategoryList();
    Member getMember(String email);
    long writeBoard(WriteBoardDto board);
    long saveFile(MultipartFile multipartFile) throws IOException;
    void saveBoardfile(long boardId, long fileupId);
}
