package shoes.skream.project.mapper.hyun;

import org.apache.ibatis.annotations.Mapper;

import shoes.skream.project.dto.hoya.MemberDTO;

@Mapper
public interface MemberDtoMapper {
	
	/**
	   * 회원 정보 업데이트 
	   * @param memberDTO
	   * @return
	   */
	int memberUpdatePost(MemberDTO memberDto);
	
	MemberDTO member(String email);
	
	
	
}
