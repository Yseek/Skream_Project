package shoes.skream.project.service.won;

import shoes.skream.project.domain.Board;
import shoes.skream.project.dto.BoardDto;
import shoes.skream.project.mapper.yun.BoardDtoMapper;
import shoes.skream.project.repository.won.BoardRepositoryWon;

public class UpdateBoardServiceImpl implements UpdateBoardService{
    
    private final BoardRepositoryWon boardRepositoryWon;
    private final BoardDtoMapper boardDtoMapper;



    public UpdateBoardServiceImpl(BoardRepositoryWon boardRepositoryWon, BoardDtoMapper boardDtoMapper) {
        this.boardRepositoryWon = boardRepositoryWon;
        this.boardDtoMapper = boardDtoMapper;
    }



    @Override
    public BoardDto getBoard(long id) {
        // TODO Auto-generated method stub
        Board board = boardRepositoryWon.findById(id).get();
        BoardDto boardDto = BoardDto.from(board, boardDtoMapper);
        return boardDto;
    }
    
}
