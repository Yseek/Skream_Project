package shoes.skream.project.service.won;

import shoes.skream.project.domain.Fileup;
import shoes.skream.project.dto.won.UpdateBoardDto;

public interface UpdateBoardService {
    UpdateBoardDto getBoard(long id);
    Fileup getFileup(long fileId);
    void updateBoard(UpdateBoardDto updateBoardDto);
}
