package shoes.skream.project.service.won;

import java.util.List;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Boardfile;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.dto.UpdateBoardDto;
import shoes.skream.project.repository.won.BoardRepositoryWon;
import shoes.skream.project.repository.won.BoardfileRepositoryWon;

public class UpdateBoardServiceImpl implements UpdateBoardService{
    
    private final BoardRepositoryWon boardRepositoryWon;
    private final BoardfileRepositoryWon boardfileRepositoryWon;

    public UpdateBoardServiceImpl(BoardRepositoryWon boardRepositoryWon, BoardfileRepositoryWon boardfileRepositoryWon) {
        this.boardRepositoryWon = boardRepositoryWon;
        this.boardfileRepositoryWon = boardfileRepositoryWon;
    }

    @Override
    public UpdateBoardDto getBoard(long id) {
        Board board = boardRepositoryWon.findById(id).get();
        // 해당 보드의 파일 목록의 경로 모두 가져온다
        Boardfile boardfile = boardfileRepositoryWon.fin
        // Fileup fileup = 
        // List<String> fileDirList = 
        UpdateBoardDto updateboardDto = UpdateBoardDto.from(board, fileDirList);
        return updateboardDto;
    }
    
}
