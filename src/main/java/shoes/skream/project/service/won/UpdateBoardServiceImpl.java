package shoes.skream.project.service.won;

import java.util.List;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Category;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.dto.won.UpdateBoardDto;
import shoes.skream.project.repository.won.BoardRepositoryWon;
import shoes.skream.project.repository.won.BoardfileRepositoryWon;
import shoes.skream.project.repository.won.CategoryRepositoryWon;
import shoes.skream.project.repository.won.FileupRepositoryWon;

public class UpdateBoardServiceImpl implements UpdateBoardService{
    
    private final BoardRepositoryWon boardRepositoryWon;
    private final BoardfileRepositoryWon boardfileRepositoryWon;
    private final FileupRepositoryWon fileupRepositoryWon;
    private final CategoryRepositoryWon categoryRepositoryWon;

    public UpdateBoardServiceImpl(BoardRepositoryWon boardRepositoryWon, BoardfileRepositoryWon boardfileRepositoryWon
                                , FileupRepositoryWon fileupRepositoryWon, CategoryRepositoryWon categoryRepositoryWon) {
        this.boardRepositoryWon = boardRepositoryWon;
        this.boardfileRepositoryWon = boardfileRepositoryWon;
        this.fileupRepositoryWon = fileupRepositoryWon;
        this.categoryRepositoryWon = categoryRepositoryWon;
    }

    @Override
    public UpdateBoardDto getBoard(long id) {
        Board board = boardRepositoryWon.findById(id).get();
        List<Long> fileIdList = boardfileRepositoryWon.findByBoardId(id);
        List<Fileup> fileList = fileupRepositoryWon.findByFileId(fileIdList);
        UpdateBoardDto updateboardDto = UpdateBoardDto.from(board, fileList);
        return updateboardDto;
    }

    @Override
    public Fileup getFileup(long fileId) {
        return fileupRepositoryWon.findById(fileId).get();
    }

    @Override
    public void updateBoard(UpdateBoardDto updateBoardDto) {
        Board board = boardRepositoryWon.findById(updateBoardDto.getSeq()).get();
        board.setSubject(updateBoardDto.getSubject());
        board.setContent(updateBoardDto.getContent());
        Category category = categoryRepositoryWon.findById(updateBoardDto.getCategory()).get();
        board.setCategory(category);
        boardRepositoryWon.save(board);
    }
}
