package shoes.skream.project.service.won;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Boardfile;
import shoes.skream.project.domain.Category;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.domain.Member;
import shoes.skream.project.dto.WriteBoardDto;
import shoes.skream.project.repository.won.CategoryRepositoryWon;
import shoes.skream.project.repository.won.FileupRepositoryWon;
import shoes.skream.project.repository.won.MemberRepositoryWon;
import shoes.skream.project.repository.won.BoardRepositoryWon;
import shoes.skream.project.repository.won.BoardfileRepositoryWon;

public class WriteBoardServiceImpl implements WriteBoardService{

    @Value("${file.dir}")
    private String fileDir;

    private final BoardRepositoryWon boardRepositoryWon;
    private final MemberRepositoryWon memberRepositoryWon;
    private final CategoryRepositoryWon categoryRepositoryWon;
    private final FileupRepositoryWon fileupRepositoryWon;
    private final BoardfileRepositoryWon boardfileRepositoryWon;
    
    public WriteBoardServiceImpl(BoardRepositoryWon boardRepositoryWon, MemberRepositoryWon memberRepositoryWon
                            , CategoryRepositoryWon categoryRepositoryWon, FileupRepositoryWon fileupRepositoryWon
                            ,BoardfileRepositoryWon boardfileRepositoryWon){
        this.boardRepositoryWon = boardRepositoryWon;
        this.memberRepositoryWon = memberRepositoryWon;
        this.categoryRepositoryWon = categoryRepositoryWon;
        this.fileupRepositoryWon = fileupRepositoryWon;
        this.boardfileRepositoryWon = boardfileRepositoryWon;
    }

    @Override
    public long writeBoard(WriteBoardDto boardDto) {
        Board board = new Board();
        board.setSubject(boardDto.getSubject());
        board.setContent(boardDto.getContent());
        Member member = memberRepositoryWon.findById(boardDto.getMember())
                                            .orElseThrow(IllegalArgumentException::new);
        board.setMember(member);
        Category category = categoryRepositoryWon.findById(boardDto.getCategory())
                                                    .orElseThrow(IllegalArgumentException::new);
        board.setCategory(category);      
        return boardRepositoryWon.save(board).getBoardId();
    }

    @Override
    public long saveFile(MultipartFile file) throws IOException{
        String origName = "";
        String uuid = "";
        String extension = ""; 
        String savedName = "";
        String savedPath = "";
        if (file.isEmpty()) {
            // 업로드할 이미지 선택 안할 경우 디폴트 이미지 업로드
            File defaultFile = new File("images/noImage.png");
            origName = defaultFile.getName();
            savedName = origName;
            savedPath = "images/noImage.png";
        }else{
            origName = file.getOriginalFilename(); // 원래 파일 이름 추출
            uuid = UUID.randomUUID().toString(); // 파일 이름으로 쓸 uuid 생성
            extension = origName.substring(origName.lastIndexOf(".")); // 확장자 추출(ex : .png)
            savedName = uuid + extension; // uuid와 확장자 결합
            savedPath = fileDir + savedName; // 파일을 불러올 때 사용할 파일 경로
        }

        Fileup fileup = Fileup.builder()
                .orgnm(origName)
                .savednm(savedName)
                .savedpath(savedPath)
                .build();
        
        if (!file.isEmpty()) {
            file.transferTo(new File(savedPath)); // 실제로 로컬에 uuid를 파일명으로 저장
        }
        return fileupRepositoryWon.save(fileup).getFileId(); // 데이터베이스에 파일 정보 저장
    }

    @Override
    public void saveBoardfile(long boardId, long fileupId) {
        // TODO Auto-generated method stub
        Boardfile boardfile = new Boardfile();
        boardfile.setBoardId(boardId);
        boardfile.setFileupFileId(fileupId);
        boardfileRepositoryWon.save(boardfile);
    }

    @Override
    public Member getMember(String email) {
        // TODO Auto-generated method stub
        Member member = memberRepositoryWon.findById(email).get();
        return member;
    }
    
    
}
