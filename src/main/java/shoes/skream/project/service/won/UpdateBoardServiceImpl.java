package shoes.skream.project.service.won;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Boardfile;
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
        // 해당 보드의 파일 목록의 경로 모두 가져온다
        List<Long> fileIdList = boardfileRepositoryWon.findByBoardId(id);
        log.info("#### fileIdList 받아온 후: {}", fileIdList);
        //Fileup fileup = fileupRepositoryWon.findByFileId(boardfile);
        List<String> fileDirList = fileupRepositoryWon.findByFileId(fileIdList);
        log.info("#### fileDirList 받아온 후: {}", fileDirList);
        UpdateBoardDto updateboardDto = UpdateBoardDto.from(board, fileDirList);
        return updateboardDto;
    }
}
