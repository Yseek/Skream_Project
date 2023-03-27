package shoes.skream.project.mapper.yun;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shoes.skream.project.domain.Boardfile;
import shoes.skream.project.domain.Fileup;

@Mapper
public interface BoardDtoMapper {
	List<Boardfile> selectBoardFile(long boardId);
	Fileup selectFileup(long fileId);
}
