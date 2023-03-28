package shoes.skream.project.mapper.yun;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shoes.skream.project.domain.Boardfile;
import shoes.skream.project.domain.Comment;
import shoes.skream.project.domain.Fileup;
import shoes.skream.project.domain.Member;
import shoes.skream.project.domain.Recommend;
import shoes.skream.project.domain.Recomment;

@Mapper
public interface BoardDtoMapper {
	List<Boardfile> selectBoardFile(long boardId);
	Fileup selectFileup(long fileId);
	List<Comment> selectComments(long boardId);
	Member selectMember(String email);
	List<Recomment> listRecomment(long commentId);
	List<Recommend> listRecommend(long boardId);
}
