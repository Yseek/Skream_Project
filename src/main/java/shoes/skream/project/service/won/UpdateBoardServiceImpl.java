package shoes.skream.project.service.won;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import shoes.skream.project.domain.Board;
import shoes.skream.project.dto.UpdateBoardDto;
import shoes.skream.project.repository.won.BoardRepositoryWon;
import shoes.skream.project.repository.won.BoardfileRepositoryWon;
import shoes.skream.project.repository.won.FileupRepositoryWon;

@Slf4j
public class UpdateBoardServiceImpl implements UpdateBoardService{
    
    private final BoardRepositoryWon boardRepositoryWon;
    private final BoardfileRepositoryWon boardfileRepositoryWon;
    private final FileupRepositoryWon fileupRepositoryWon;

    public UpdateBoardServiceImpl(BoardRepositoryWon boardRepositoryWon, BoardfileRepositoryWon boardfileRepositoryWon
                                , FileupRepositoryWon fileupRepositoryWon) {
        this.boardRepositoryWon = boardRepositoryWon;
        this.boardfileRepositoryWon = boardfileRepositoryWon;
        this.fileupRepositoryWon = fileupRepositoryWon;
    }

    @Override
    public UpdateBoardDto getBoard(long id) {
        Board board = boardRepositoryWon.findById(id).get();
        List<Long> fileIdList = boardfileRepositoryWon.findByBoardId(id);
        List<String> fileDirList = fileupRepositoryWon.findByFileId(fileIdList);
        UpdateBoardDto updateboardDto = UpdateBoardDto.from(board, fileDirList);
        return updateboardDto;
    }
}
