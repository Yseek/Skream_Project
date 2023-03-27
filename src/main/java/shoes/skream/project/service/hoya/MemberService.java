package shoes.skream.project.service.hoya;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shoes.skream.project.domain.Member;
import shoes.skream.project.dto.hoya.MemberDTO;
import shoes.skream.project.repository.hoya.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private  final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        Member member = Member.toMember(memberDTO);
        memberRepository.save(member);
    }
}
