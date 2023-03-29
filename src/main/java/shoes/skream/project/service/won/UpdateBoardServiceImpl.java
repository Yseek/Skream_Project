package shoes.skream.project.service.won;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import shoes.skream.project.domain.Board;
import shoes.skream.project.domain.Boardfile;
import shoes.skream.project.domain.Category;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.dto.won.UpdateBoardDto;
import shoes.skream.project.repository.won.BoardRepositoryWon;
import shoes.skream.project.repository.won.BoardfileRepositoryWon;
import shoes.skream.project.repository.won.CategoryRepositoryWon;
import shoes.skream.project.repository.won.FileupRepositoryWon;

public class UpdateBoardServiceImpl implements UpdateBoardService{
    
    @Value("${file.dir}")
    private String fileDir;

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

    @Override
    public long saveUpdateFile(MultipartFile file) throws IOException{
        if (file.isEmpty()) {
            return -1;
        }
        String origName = file.getOriginalFilename(); // 원래 파일 이름 추출
        String uuid = UUID.randomUUID().toString(); // 파일 이름으로 쓸 uuid 생성
        String extension = origName.substring(origName.lastIndexOf(".")); // 확장자 추출(ex : .png)
        String savedName = uuid + extension; // uuid와 확장자 결합
        String savedPath = fileDir + savedName; // 파일을 불러올 때 사용할 파일 경로

        Fileup fileup = Fileup.builder()
                .orgnm(origName)
                .savednm(savedName)
                .savedpath(savedPath)
                .build();
        
        file.transferTo(new File(savedPath)); // 실제로 로컬에 uuid를 파일명으로 저장
        return fileupRepositoryWon.save(fileup).getFileId(); // 데이터베이스에 파일 정보 저장
    }

    @Override
    public void saveUpdateBoardfile(long boardId, long fileupId) {
        Boardfile boardfile = new Boardfile();
        boardfile.setBoardId(boardId);
        boardfile.setFileupFileId(fileupId);
        boardfileRepositoryWon.save(boardfile);
    }

    @Override
    @Transactional
    public void deleteUploadedFile(String removeList) {
        // removeList(직렬화된 json) -> 핸들링
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonarray = (JSONArray) parser.parse(removeList);
            for(int i=0; i < jsonarray.size(); i++){
                JSONObject obj = (JSONObject) jsonarray.get(i);
                String fileIdStr = (String) obj.get("fileId");
                Long fileId = Long.parseLong(fileIdStr);
                // 로컬 파일 삭제
                Fileup fileup = fileupRepositoryWon.findById(fileId).orElse(null);
                String savedpath = fileup.getSavedpath();
                File f = new File(savedpath);
                if(f.exists()){
                    f.delete();
                }
                // DB 삭제
                fileupRepositoryWon.deleteById(fileId);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFileup(long fileId) {
        fileupRepositoryWon.deleteById(fileId);
    }

    @Override
    public long setDefaultImage(long boardId) throws IOException{
        File defaultFile = new File("images/noImage.png");
        String origName = defaultFile.getName();
        String savedName = origName;
        String savedPath = "images/noImage.png";

        Fileup fileup = Fileup.builder()
                .orgnm(origName)
                .savednm(savedName)
                .savedpath(savedPath)
                .build();
        // fileup
        return fileupRepositoryWon.save(fileup).getFileId();
    }

    
}
