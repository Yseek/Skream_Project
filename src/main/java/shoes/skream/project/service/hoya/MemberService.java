package shoes.skream.project.service.hoya;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shoes.skream.project.domain.Member;
import shoes.skream.project.dto.hoya.MemberDTO;
import shoes.skream.project.mapper.hyun.MemberDtoMapper;
import shoes.skream.project.repository.hoya.MemberRepository;
import shoes.skream.project.repository.yun.BoardMemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final MemberDtoMapper memberDtoMapper;
	private final BoardMemberRepository boardMemberRepository;

	public void save(MemberDTO memberDTO) {
		Member member = Member.toMember(memberDTO);
		memberRepository.save(member);
	}

	public MemberDTO login(MemberDTO memberDTO) {
		Optional<Member> byEmail = memberRepository.findByEmail(memberDTO.getEmail());
		if (byEmail.isPresent()) {
			Member member = byEmail.get();
			if (member.getPwd().equals(memberDTO.getPwd())) {
				MemberDTO dto = MemberDTO.toMemberDTO(member);
				return dto;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 회원 정보 가져오기
	 * 
	 * @param memberDTO
	 * @return
	 */
	public MemberDTO member(String email) {

		return memberDtoMapper.member(email);
	}

	/**
	 * 회원 정보 업데이트
	 * 
	 * @param memberDTO
	 * @return
	 */
	public int memberUpdatePost(MemberDTO memberDto) {

		return memberDtoMapper.memberUpdatePost(memberDto);
	}

	public void memberDelete(String email) {
		boardMemberRepository.deleteById(email);
	}
}
