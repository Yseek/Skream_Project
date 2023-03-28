package shoes.skream.project.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import shoes.skream.project.dto.hoya.MemberDTO;

@Getter
@Setter
@Entity
public class Member extends RUDate{
	@Id
	@Column(name = "EMAIL")
	private String email;
	private String name;
	private Date birth;
	private String phone;
	private String pwd;

	public static Member toMember(MemberDTO memberDTO){
		Member member = new Member();
		member.setEmail(memberDTO.getEmail());
		member.setPwd(memberDTO.getPwd());
		member.setName(memberDTO.getName());
		member.setBirth(memberDTO.getBirth());
		member.setPhone(memberDTO.getPhone());
		return member;
	}
}
