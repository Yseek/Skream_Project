package shoes.skream.project.service.won;

import java.util.Optional;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Category;
import shoes.skream.project.domain.Member;
import shoes.skream.project.dto.WriteBoardDto;
import shoes.skream.project.repository.won.CategoryRepositoryWon;
import shoes.skream.project.repository.won.MemberRepositoryWon;
import shoes.skream.project.repository.won.WriteBoardRepository;

public class WriteBoardServiceImpl implements WriteBoardService{

    WriteBoardRepository writeBoardRepository;
    MemberRepositoryWon memberRepositoryWon;
    CategoryRepositoryWon categoryRepositoryWon;
    
    public WriteBoardServiceImpl(WriteBoardRepository repository){
        this.writeBoardRepository = repository;
    }

    @Override
    public void write(WriteBoardDto boardDto) {
        // TODO Auto-generated method stub
        Board board = new Board();
        board.setSubject(boardDto.getSubject());
        board.setContent(boardDto.getContent());
        // category, member
        Member member = memberRepositoryWon.findById(boardDto.getMember());
        board.setMember(member);
        Optional<Category> category = categoryRepositoryWon.findById(Integer.parseInt(boardDto.getCategory()));
        // Long.parseLong(boardDto.getCategory())
        

        writeBoardRepository.save(board);
        System.out.println("##### 서비스 진입됨, Content: " + boardDto.getContent());

    }
    
}
