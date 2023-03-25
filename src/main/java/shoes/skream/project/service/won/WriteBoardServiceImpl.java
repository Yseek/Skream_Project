package shoes.skream.project.service.won;

import shoes.skream.project.domain.Board;
import shoes.skream.project.dto.WriteBoardDto;
import shoes.skream.project.repository.won.WriteBoardRepository;

public class WriteBoardServiceImpl implements WriteBoardService{
    
    WriteBoardRepository repository;

    @Override
    public void write(WriteBoardDto boardDto) {
        // TODO Auto-generated method stub
        /* Board board = null;
        board.setSubject(boardDto.getSubject());
        board.setContent(boardDto.getContent());

        repository.save(board); */

    }
    
}
