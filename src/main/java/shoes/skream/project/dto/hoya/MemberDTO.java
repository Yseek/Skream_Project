package shoes.skream.project.dto.hoya;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoes.skream.project.domain.Member;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
  
  private String email;
  private String pwd;
  private String checkPwd;
  private String name;
  private Date birth;
  private String phone;

  public static MemberDTO toMemberDTO(Member member) {
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setEmail(member.getEmail());
    memberDTO.setPwd(member.getPwd());
	memberDTO.setName(member.getName());
    return memberDTO;
  }
}