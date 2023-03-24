package shoes.skream.project.mapper.yun;

import org.apache.ibatis.annotations.Mapper;

import shoes.skream.project.domain.Boardfile;
import shoes.skream.project.domain.Fileup;

@Mapper
public interface BoardDtoMapper {
	Boardfile selectBoardFile(long boardId);
	Fileup selectFileup(long fileId);
}
