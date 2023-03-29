package shoes.skream.project.service.won;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import shoes.skream.project.domain.Fileup;
import shoes.skream.project.dto.won.UpdateBoardDto;

public interface UpdateBoardService {
    UpdateBoardDto getBoard(long id);
    Fileup getFileup(long fileId);
    void updateBoard(UpdateBoardDto updateBoardDto);
    long saveUpdateFile(MultipartFile file) throws IOException;
    void saveUpdateBoardfile(long boardId, long fileupId);
    void deleteUploadedFile(String removeList);
    void deleteFileup(long fileId);
    long setDefaultImage(long boardId) throws IOException;
}
