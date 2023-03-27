package shoes.skream.project.service.hoya;

import java.util.Optional;

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
    public MemberDTO login(MemberDTO memberDTO) {
        Optional<Member> byEmail =memberRepository.findByEmail(memberDTO.getEmail());
        if(byEmail.isPresent()) {
          Member member = byEmail.get();
          if(member.getPwd().equals(memberDTO.getPwd())){
            MemberDTO dto=MemberDTO.toMemberDTO(member);
            return dto;
          }else{
            return null;
          }
        }else{
          return null;
        }
    }
}
